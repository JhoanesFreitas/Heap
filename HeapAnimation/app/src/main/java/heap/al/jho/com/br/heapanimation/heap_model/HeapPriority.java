package heap.al.jho.com.br.heapanimation.heap_model;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

/**
 * Created by jhoanesfreitas on 19/07/16.
 */
public class HeapPriority{

  private static final Integer sizeVector = 10;

  private List<TextView> list;
  private Context context;
  private Integer[] vector = new Integer[sizeVector];
  private TextView tvTrocas;
  private int cont = 1;
  boolean status = false;

  public HeapPriority(List list, Context context, TextView tvTrocas){
    this.list = list;
    this.context = context;
    this.tvTrocas = tvTrocas;
    fillZero();
    fillVector(1);
  }

  private void fillZero(){
    for(int i = 0; i < sizeVector; i++){
      vector[i] = 0;
    }
  }

  public void print(){
    for(int i = 0; i < sizeVector; i++){
      Log.d("vector", vector[i] + " ");
    }
  }

  private void fillVector(final int h){

    new CountDownTimer(3000, 1000){

      Random random = new Random();
      int i = h;

      @Override public void onTick(long millisUntilFinished){}

      @Override public void onFinish(){
        vector[i - 1] = random.nextInt(10);
        list.get(i - 1).setText(vector[i - 1] + "");
        heapUp(i / 2);

        if(i == 10){
          Toast.makeText(context, "Finish", Toast.LENGTH_SHORT).show();
          Log.d("cancel", "finish! ");
          this.cancel();
        } else{
          fillVector(++i);
        }
      }
    }.start();
  }

  private void heapUp(final Integer n){

    new CountDownTimer(500, 1000){

      Integer k = n;

      @Override public void onTick(long millisUntilFinished){}

      @Override public void onFinish(){

        if(k * 2 - 1 < sizeVector && k > 0){
          if(vector[k * 2 - 1] > vector[k - 1]){
            swap(k * 2 - 1, k - 1);
            list.get(k * 2 - 1).setText(vector[k * 2 - 1] + "");
            list.get(k - 1).setText(vector[k - 1] + "");
            tvTrocas.setText(cont++ + "");
          }
        }
        if(k * 2 < sizeVector && k > 0){
          if(vector[k * 2] > vector[k - 1]){
            swap(k * 2, k - 1);
            list.get(k * 2).setText(vector[k * 2] + "");
            list.get(k - 1).setText(vector[k - 1] + "");
            tvTrocas.setText(cont++ + "");
          }
        }

        if(k < 0){
          this.cancel();
        } else{
          k = k / 2;
          heapUp(k);
        }
      }
    }.start();
  }

  private void swap(Integer i, Integer j){
    Integer aux;

    aux = vector[i];
    vector[i] = vector[j];
    vector[j] = aux;
  }

}
