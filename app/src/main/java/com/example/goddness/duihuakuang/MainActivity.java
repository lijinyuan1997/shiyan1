package com.example.goddness.duihuakuang;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.goddness.duihuakuang.R.id.fab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button)this.findViewById(R.id.ButtonOK);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setPositiveButton("确认",new DialogInterface.OnClickListener(){
                   public void onClick(DialogInterface dialog, int which){
                   }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮~", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();
            }
        });
        button = (Button) this.findViewById(R.id.ButtonOK);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View login_main = inflater.inflate(R.layout.login_main,null);
                builder.setView(login_main);
                builder.setTitle("登陆页面");
                builder.setPositiveButton(R.string.login,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        final EditText uid = (EditText)login_main.findViewById(R.id.editTextUserId);
                        final EditText psw = (EditText)login_main.findViewById(R.id.editTextPwd);
                        if(uid.getText().toString().equals("abc") && psw.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"登陆成功~",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"登录失败！",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNeutralButton(R.string.cancel,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
