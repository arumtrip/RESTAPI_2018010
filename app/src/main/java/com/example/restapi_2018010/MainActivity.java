package com.example.restapi_2018010;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tv_data);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<GetData>> call = api.getPost();

        call.enqueue(new Callback<List<GetData>>() {
            @Override
            public void onResponse(Call<List<GetData>> call, Response<List<GetData>> response) {
                if (response.isSuccessful()){
                    List<GetData> posts= response.body();
                    for (GetData data : posts){
                        String isidata = "";
                        isidata += "UserId :"+ data.getUserId()+ "\n";
                        isidata += "Id :"+ data.getId()+ "\n";
                        isidata += "Title :"+ data.getTitle()+ "\n";
                        isidata += "Description :"+ data.getText()+ "\n";

                        tvData.append(isidata);
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<GetData>> call, Throwable t) {
                tvData.setText(t.getMessage());
            }
        });
    }
}