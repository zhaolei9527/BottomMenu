package sakura.bottommenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sakura.bottommenulibrary.bottompopfragmentmenu.BottomMenuFragment;
import sakura.bottommenulibrary.bottompopfragmentmenu.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                new BottomMenuFragment(MainActivity.this)
                        .setMenuItems(new MenuItem("条目一"))
                        .setMenuItems(new MenuItem("条目二"))
                        .setMenuItems(new MenuItem("条目三"))
                        .setOnItemClickListener(new BottomMenuFragment.OnItemClickListener() {
                            @Override
                            public void onItemClick(TextView menu_item, int position) {
                                Toast.makeText(MainActivity.this, menu_item.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

                break;
        }
    }
}
