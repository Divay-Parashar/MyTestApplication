package com.example.test_library;


import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface VolleyCallback {

    void onSuccessResponse(JSONObject result);

    void onErrorResponse(VolleyError volleyError);

}
