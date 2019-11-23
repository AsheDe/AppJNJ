package cu.bellalogica.jnjcuba2019;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.PathWrapper;
import com.graphhopper.util.Constants;
import com.graphhopper.util.Helper;
import com.graphhopper.util.Parameters.Algorithms;
import com.graphhopper.util.Parameters.Routing;
import com.graphhopper.util.PointList;
import com.graphhopper.util.ProgressListener;
import com.graphhopper.util.StopWatch;

import org.oscim.android.MapView;
import org.oscim.android.canvas.AndroidGraphics;
import org.oscim.backend.canvas.Bitmap;
import org.oscim.core.GeoPoint;
import org.oscim.core.MapPosition;
import org.oscim.core.Tile;
import org.oscim.event.Gesture;
import org.oscim.event.GestureListener;
import org.oscim.event.MotionEvent;
import org.oscim.layers.Layer;
import org.oscim.layers.marker.ItemizedLayer;
import org.oscim.layers.marker.MarkerItem;
import org.oscim.layers.marker.MarkerSymbol;
import org.oscim.layers.tile.buildings.BuildingLayer;
import org.oscim.layers.tile.vector.VectorTileLayer;
import org.oscim.layers.tile.vector.labeling.LabelLayer;
import org.oscim.layers.vector.PathLayer;
import org.oscim.layers.vector.geometries.Style;
import org.oscim.theme.VtmThemes;
import org.oscim.tiling.source.mapfile.MapFileTileSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;




public class FragmentoMapa extends Fragment {

    private static final int NEW_MENU_ID = Menu.FIRST + 1;
    private MapView mapView;
    private GraphHopper hopper;
    private GeoPoint start;
    private GeoPoint end;

    private volatile boolean shortestPathRunning = false;
    private String currentArea = "cuba";

    private File mapsFolder;
    private ItemizedLayer<MarkerItem> itemizedLayer;
    private PathLayer pathLayer;
    private Context contexto;
    private View vistageneral;
    private ArrayList<Localizacion> puntos;
    RecyclerView lista_locaciones;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contexto = container.getContext() ;
        vistageneral = inflater.inflate(R.layout.fragment_mapa,container,false);
        mapView = vistageneral.findViewById(R.id.mapa_mostrar) ;
        puntos  =   getArguments().getParcelableArrayList("puntos");

       Tile.SIZE = Tile.calculateTileSize(getResources().getDisplayMetrics().scaledDensity);
        mapsFolder = new File(Environment.getExternalStorageDirectory() + File.separator + "JNJCUBA" + File.separator + "mapas");

        if (!mapsFolder.exists())
        {
            mapsFolder.mkdirs();
            copyAssets();
        }
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                loadMap(new File(mapsFolder + File.separator + currentArea + ".map").getAbsolutePath());
               // Log.d("file","file");
            }
        });


        synchronized (mapsFolder){
           // Log.d("file2","file2");
            mapView.map().setMapPosition(puntos.get(0).getPunto().getLatitude(),puntos.get(0).getPunto().getLongitude(), 1 << 9);
            lista_locaciones = vistageneral.findViewById(R.id.lista_locaciones);
            AdptLocaciones adpter = new AdptLocaciones(puntos);
            lista_locaciones.setAdapter(adpter);
            lista_locaciones.setLayoutManager(new LinearLayoutManager(contexto,LinearLayoutManager.HORIZONTAL,false));
         if(getActivity() instanceof Mapa) {
             ConstraintLayout.LayoutParams lparms = (ConstraintLayout.LayoutParams) lista_locaciones.getLayoutParams();
             lparms.bottomMargin = 24;
             lista_locaciones.setLayoutParams(lparms);
         }

         return vistageneral;
        }


    }


  /*  @Override
     void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hopper != null)
            hopper.close();

        hopper = null;
        // necessary?
        System.gc();

        // Cleanup VTM
        mapView.map().destroy();
    }*/

   /* boolean isReady() {
        // only return true if already loaded
        if (hopper != null)
            return true;

        logUser("Prepare finished but hopper not ready. This happens when there was an error while loading the files");
        return false;
    }*/

    void loadMap(String map) {
       // logUser("CARGANDO MAPA");

        // Map events receiver
        // mapView.map().layers().add(new MapEventsReceiver(mapView.map()));

        // Map file source
        MapFileTileSource tileSource = new MapFileTileSource();
        tileSource.setMapFile(map);
        VectorTileLayer l = mapView.map().setBaseMap(tileSource);
        mapView.map().setTheme(VtmThemes.DEFAULT);
        mapView.map().layers().add(new BuildingLayer(mapView.map(), l));
        mapView.map().layers().add(new LabelLayer(mapView.map(), l));

        // Markers layer
        itemizedLayer = new ItemizedLayer<>(mapView.map(), (MarkerSymbol) null);
        //itemizedLayer.addItem(createMarkerItem(new GeoPoint(20.0223, -75.82178), R.drawable.ic_add_location_black_24dp));


       /* GeoPoint punto = new GeoPoint(20.05069, -75.94903) ;
        itemizedLayer.addItem(createMarkerItem(punto, R.drawable.cruz));

        GeoPoint punto2 = new GeoPoint(20.0241, -75.80899) ;
        itemizedLayer.addItem(createMarkerItem(punto2, R.drawable.cruz));

        GeoPoint punto3 = new GeoPoint(20.02096, -75.82961) ;
        itemizedLayer.addItem(createMarkerItem(punto3, R.drawable.cruz));
        // mapView.map().updateMap(true);

        GeoPoint punto4 = new GeoPoint(20.01533, -75.83718) ;
        itemizedLayer.addItem(createMarkerItem(punto4, R.drawable.cruz));

        GeoPoint punto5 = new GeoPoint(20.02285, -75.81556) ;
        itemizedLayer.addItem(createMarkerItem(punto5, R.drawable.cruz));
        // mapView.map().updateMap(true);
*/



        for(Localizacion punto:puntos)
        {
            itemizedLayer.addItem(createMarkerItem(punto.getPunto(),punto.getRecurso() ));
        }

        mapView.map().layers().add(itemizedLayer);
        // Map position(Plaza de Marte)
//        mapView.map().setMapPosition(puntos.get(0).getPunto().getLatitude(),puntos.get(0).getPunto().getLongitude(), 1 << 16);


       // setContentView(this.mapView);
        loadGraphStorage();
    }

    private void copyAssets() {
        AssetManager assetManager = contexto.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "No se pudo obtener el mapa", e);
        }
        if (files != null) for (String filename : files) {
            if(filename.endsWith(".map")) {
                InputStream in = null;
                OutputStream out = null;
                try {
                    in = assetManager.open(filename);
                    //  File outFile = new File(getExternalFilesDir(null), filename);
                    File outFile = new File(mapsFolder, filename);
                    out = new FileOutputStream(outFile);
                    copyFile(in, out);
                } catch (IOException e) {
                    Log.e("tag", "Fallo al copiar el archivo: " + filename, e);
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    void loadGraphStorage() {
     //   logUser("loading graph (" + Constants.VERSION + ") ... ");
        new GHAsyncTask<Void, Void, Path>() {
            protected Path saveDoInBackground(Void... v) throws Exception {
                GraphHopper tmpHopp = new GraphHopper().forMobile();
                tmpHopp.load(new File(mapsFolder, currentArea + "-latest.osm-gh").getAbsolutePath());
                log("found graph " + tmpHopp.getGraphHopperStorage().toString() + ", nodes:" + tmpHopp.getGraphHopperStorage().getNodes());
                hopper = tmpHopp;
                return null;
            }

            protected void onPostExecute(Path o) {
                if (hasError()) {
                 //   logUser("Ha ocurrido un error mientras se cargaba el mapa"
                   //         + getErrorMessage());
                } else {
                 //   logUser("Finished loading graph. Long press to define where to start and end the route.");
                }

            }
        }.execute();
    }

    @SuppressWarnings("deprecation")
    private MarkerItem createMarkerItem(GeoPoint p, int resource) {
        Drawable drawable = getResources().getDrawable(resource);
        Bitmap bitmap = AndroidGraphics.drawableToBitmap(drawable);
        MarkerSymbol markerSymbol = new MarkerSymbol(bitmap, 0.5f, 1);
        MarkerItem markerItem = new MarkerItem("", "", p);
        markerItem.setMarker(markerSymbol);
        return markerItem;
    }

    private void logUser(String str) {
        log(str);
        Toast.makeText(contexto, str, Toast.LENGTH_LONG).show();
    }

    private void log(String str) {
        Log.i("GH", str);
    }

    private void log(String str, Throwable t) {
        Log.i("GH", str, t);
    }

    class AdptLocaciones extends RecyclerView.Adapter
    {
        ArrayList<Localizacion> mPoints;

        public AdptLocaciones(ArrayList<Localizacion> mpoits) {
            mPoints = mpoits ;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_locacion,viewGroup,false);
            return new HoldLocacion(vista);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,final int i) {

            ((HoldLocacion)viewHolder).textView.setText(mPoints.get(i).getNombre_lugar());

              Glide.with(contexto).load(mPoints.get(i).getImagen()).into(((HoldLocacion)viewHolder).imageView);


            ((HoldLocacion)viewHolder).itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mapView.map().setMapPosition(mPoints.get(i).getPunto().getLatitude(),mPoints.get(i).getPunto().getLongitude(), 1 << 16);
                }
            });
        }

        @Override
        public int getItemCount() {
            return puntos.size();
        }
    }

    class HoldLocacion extends RecyclerView.ViewHolder
    {
        TextView textView ;
        ImageView imageView;
        public HoldLocacion(@NonNull View itemView) {
            super(itemView);
           imageView = (ImageView) itemView.findViewById(R.id.img_lugar);
           textView = (TextView) itemView.findViewById(R.id.texto_lugar);
        }
    }

}
