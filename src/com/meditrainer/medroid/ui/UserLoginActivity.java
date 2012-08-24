package com.meditrainer.medroid.ui;

 import java.util.ArrayList;
 import java.util.List;

  import org.apache.http.HttpEntity;
  import org.apache.http.HttpResponse;
  import org.apache.http.NameValuePair;
  import org.apache.http.client.HttpClient;
  import org.apache.http.client.entity.UrlEncodedFormEntity;
  import org.apache.http.client.methods.HttpPost;
  import org.apache.http.impl.client.DefaultHttpClient;
  import org.apache.http.message.BasicNameValuePair;
  import org.apache.http.util.EntityUtils;
  import org.json.JSONException;
  import org.json.JSONObject;

  import android.app.Activity;
  import android.app.ProgressDialog;
  import android.content.Intent;
  import android.os.AsyncTask;
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View; 
  import android.widget.Button;
   import android.widget.EditText;
  import android.widget.TextView;


public class UserLoginActivity extends Activity {
/*
EditText usname;
EditText pass;
TextView tv;
HttpClient client;
HttpPost post;
@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
setContentView(R.layout.login_lay);
 tv=(TextView) findViewById(R.id.login_stat_tv);
 usname=(EditText)findViewById(R.id.uname);
 pass=(EditText)findViewById(R.id.pass);
Button login=(Button)findViewById(R.id.login_but);
Button cancel=(Button)findViewById(R.id.cancel_but);

client = new DefaultHttpClient();
String url="http://10.0.2.2:7001/proj/login.jsp";
post = new HttpPost(url);
login.setOnClickListener(new View.OnClickListener() {

    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        new login().execute("");
    }
});

cancel.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        // TODO Auto-generated method stub
        usname.getText().clear();
        pass.getText().clear();
    }
});

}



@Override
protected void onDestroy() {
// TODO Auto-generated method stub
super.onDestroy();
}



 @Override
 protected void onPause() {
// TODO Auto-generated method stub
super.onPause();
finish();
}

private class login extends AsyncTask<String, Void, JSONObject>{
ProgressDialog dialog = ProgressDialog.show(Login_Menu.this, "", "Authenticating,   Please wait...");

@Override
protected JSONObject doInBackground(String... params) {
    // TODO Auto-generated method stub
    Log.i("thread", "Doing Something...");
   //authentication operation
try{

    List<NameValuePair> pairs = new ArrayList<NameValuePair>();   
    pairs.add(new BasicNameValuePair("username",usname.getText().toString()));   
    pairs.add(new BasicNameValuePair("password",pass.getText().toString()));   
    post.setEntity(new UrlEncodedFormEntity(pairs));   
    HttpResponse response = client.execute(post);
    int status=response.getStatusLine().getStatusCode();

    if(status == 200)
    {
        HttpEntity e=response.getEntity();
        String data=EntityUtils.toString(e);
        JSONObject last=new JSONObject(data);
        return last;

    }

}

catch(Exception e)
{
    e.printStackTrace();   

}

    return null;
}

protected void onPreExecute(){
    //dialog.dismiss();
    Log.i("thread", "Started...");
    dialog.show();
}
protected void onPostExecute(JSONObject result){
    Log.i("thread", "Done...");
    String status;
    String name;
    try {
        status= result.getString("status");
        name=result.getString("uname");

       if(dialog!=null)
       {
         dialog.dismiss();
       }
       if(status.equalsIgnoreCase("yes"))
          {
        tv.setText("Login Successful...");

        Bundle newbundle=new Bundle();
        newbundle.putString("uname",name);

        Intent myIntent=new Intent(Login_Menu.this,Instruction.class);
        myIntent.putExtras(newbundle);

        startActivity(myIntent);

    }else{

    tv.setText("No User Found, please try again!");
    }
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

}} 
*/
}
