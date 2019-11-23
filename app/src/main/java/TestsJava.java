import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

public class TestsJava extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
      /*  PopupMenu x;
        x.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case 1:
                    {
                        startActivity(new Intent(getBaseContext(), Historia.class));
                    }
                }

                return false;
            }
        });


*/


        return super.onCreateView(parent, name, context, attrs);
    }
}
