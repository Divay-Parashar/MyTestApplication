package com.example.test_library;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CommonFunc {

    public static void Send_Data_to_Server(Context context, JSONObject object, final VolleyCallback callback) {

        String api = "https://mobile.msways.com/api/merchant/get-measured/measurement/deatils/";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, api, object, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("NEWdata",response.toString());
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                callback.onErrorResponse(error);
            }
        })
        {
            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        // Adding request to request queue
        Volley.newRequestQueue(context).add(jsonObjReq);
    }
}
