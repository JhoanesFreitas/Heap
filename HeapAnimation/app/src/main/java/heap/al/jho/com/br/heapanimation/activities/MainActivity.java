package heap.al.jho.com.br.heapanimation.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import heap.al.jho.com.br.heapanimation.R;
import heap.al.jho.com.br.heapanimation.heap_model.HeapPriority;

public class MainActivity extends AppCompatActivity{

  private List<TextView> list;
  private TextView tvTrocas;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ViewGroup group = (ViewGroup) toolbar.getParent();
    LayoutInflater inflater = getLayoutInflater();
    View view = inflater.inflate(R.layout.content_main, group, false);

    tvTrocas = (TextView) findViewById(R.id.tvTrocas);

    list = new ArrayList<>();
    getTextViews(view);

  }

  public void onClick(View view){
    fillZero();
    HeapPriority heapPriority = new HeapPriority(list, this, tvTrocas);
    heapPriority.print();
  }

  private void fillZero(){
    tvTrocas.setText("0");
    for(int i = 0; i < 10; i++){
      list.get(i).setText("");
    }
  }

  private void getTextViews(View view){
    TextView textView1 = (TextView) findViewById(R.id._1);
    list.add(textView1);
    TextView textView2 = (TextView) findViewById(R.id._2);
    list.add(textView2);
    TextView textView3 = (TextView) findViewById(R.id._3);
    list.add(textView3);
    TextView textView4 = (TextView) findViewById(R.id._4);
    list.add(textView4);
    TextView textView5 = (TextView) findViewById(R.id._5);
    list.add(textView5);
    TextView textView6 = (TextView) findViewById(R.id._6);
    list.add(textView6);
    TextView textView7 = (TextView) findViewById(R.id._7);
    list.add(textView7);
    TextView textView8 = (TextView) findViewById(R.id._8);
    list.add(textView8);
    TextView textView9 = (TextView) findViewById(R.id._9);
    list.add(textView9);
    TextView textView10 = (TextView) findViewById(R.id._10);
    list.add(textView10);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if(id == R.id.action_settings){
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
