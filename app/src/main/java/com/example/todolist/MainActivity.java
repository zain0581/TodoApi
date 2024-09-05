package com.example.todolist;
import android.util.Log;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.todolist.Models.ToDoTsk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        requestQueue = Volley.newRequestQueue(this);
        //getTodoItems();
        createTodoItem();

        //Button btnTakePicture = findViewById(R.id.log_task_button);


    }
    public void onSaveNewButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, CreatetodoActivity.class);
        startActivity(intent);
    }
//Get Method
    void getTodoItems(){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "http://192.168.0.223:8080/todolistt",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Type listType = new TypeToken<List<ToDoTsk>>() {}.getType();
                        List<ToDoTsk> todoItems = new Gson().fromJson(response, listType);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("***** Volley *****", "onErrorResponse: ", error);
                    }
                });

        requestQueue.add(request);
    }

    void createTodoItem() {
        // Create a new ToDoTsk object and set its values
        ToDoTsk todoItem = new ToDoTsk();
        todoItem.setName("Sample Task");


        // Convert the ToDoTsk object to JSON using Gson
        String requestBody = new Gson().toJson(todoItem);

        // Create a StringRequest with the POST method
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.0.246:8989/todoitem",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle the response here
                        Log.d("Create", "onResponse: " + response);

                        int i = Integer.valueOf(response);
                        if (i == -1) {
                            Log.d("Create", "onResponse: failed ");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle the error response here
                Log.e("Create", "onErrorResponse: ", error);
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    // Send the JSON request body
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                } catch (Exception e) {
                    Log.e("Create", "getBody: ", e);
                    return super.getBody();
                }
            }

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json"); // Set the content type to JSON
                return params;
            }
        };

        // Add the request to the Volley queue
        requestQueue.add(request);
    }




}