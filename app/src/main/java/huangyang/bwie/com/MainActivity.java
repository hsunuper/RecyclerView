package huangyang.bwie.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mdatas;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initData();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        HomeAdapter adapter=new HomeAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        mdatas = new ArrayList<>();
        for ( int i=0; i < 100; i++) {
            mdatas.add( "item"+i);
        }
    }


    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

        @Override
        public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = View.inflate(MainActivity.this,R.layout.item,null);
            MyViewHolder holder=new MyViewHolder(view);


           return holder;
        }

        @Override
        public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {

            holder.tv.setText(mdatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mdatas!=null?mdatas.size():0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
               tv= (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }
}
