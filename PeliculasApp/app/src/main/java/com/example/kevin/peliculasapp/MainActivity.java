package com.example.kevin.peliculasapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.*;
import android.support.v4.BuildConfig;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.kevin.peliculasapp.adapter.MoviesAdapter;
import com.example.kevin.peliculasapp.api.Client;
import com.example.kevin.peliculasapp.api.Service;
import com.example.kevin.peliculasapp.model.Movie;
import com.example.kevin.peliculasapp.model.MoviesResponse;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.*;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.kevin.peliculasapp.api.Client.BASE_URL;


public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private RecyclerView recyclerView;
    private MoviesAdapter adapter;
    private List<Movie> movieList;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    public static final String LOG_TAG = MoviesAdapter.class.getName ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        swipeContainer = (SwipeRefreshLayout) findViewById ( R.id.main_content );
        swipeContainer.setColorSchemeResources ( android.R.color.holo_orange_dark );
        swipeContainer.setOnRefreshListener ( new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh() {
                initViews();
                Toast.makeText ( MainActivity.this, "Peliculas actualizadas", Toast.LENGTH_SHORT ).show ();

            }
        } );
    }

    public Activity getActivity(){
        Context context = this;
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext ();
        }
        return  null;
    }

    private void initViews(){
        pd = new ProgressDialog ( this );
        pd.setMessage ( "Cargando películas..." );
        pd.setCancelable ( false );
        pd.show ();

        recyclerView = (RecyclerView) findViewById ( R.id.recycler_view );

        movieList = new ArrayList<> (  );
        adapter = new MoviesAdapter (this, movieList);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager ( new GridLayoutManager ( this, 2 ) );
        }
        else{
            recyclerView.setLayoutManager ( new GridLayoutManager ( this, 4 ) );

        }

        recyclerView.setItemAnimator ( new DefaultItemAnimator () );
        recyclerView.setAdapter ( adapter );
        adapter.notifyDataSetChanged();

        checkSortOrder ();
    }

    private void loadJSON(){
        try{
            if (com.example.kevin.peliculasapp.BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty ()){
                Toast.makeText ( getApplicationContext (), "Por favor obten primero la clave de la API desde themoviedb.org", Toast.LENGTH_SHORT ).show ();
                pd.dismiss ();
                return;
            }

            Client Client = new Client ();
            Service apiService =
                    Client.getClient ().create ( Service.class );
           final Call<MoviesResponse> call = apiService.getPopularMovies ();
            call.enqueue ( new Callback<MoviesResponse> () {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    List<Movie> movies =  response.body ().getResults ();
                    recyclerView.setAdapter ( new MoviesAdapter (getApplicationContext (), movies) );
                    recyclerView.smoothScrollToPosition ( 0 );
                    if (swipeContainer.isRefreshing ()){
                        swipeContainer.setRefreshing ( false );
                    }
                    pd.dismiss ();
                }

                @Override
                public void onFailure(retrofit2.Call<MoviesResponse> call, Throwable t) {
                    Log.d ("Error", t.getMessage ());
                    Toast.makeText ( MainActivity.this, "Error ¡No se pueden cargar las peliculas!", Toast.LENGTH_SHORT ).show ();
                }
            } );
        }catch (Exception e){
            Log.d ( "Error", e.getMessage () );
            Toast.makeText ( this, e.toString (), Toast.LENGTH_SHORT ).show ();
        }
    }

    private void loadJSON1(){
        try{
            if (com.example.kevin.peliculasapp.BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty ()){
                Toast.makeText ( getApplicationContext (), "Por favor obten primero la clave de la API desde themoviedb.org", Toast.LENGTH_SHORT ).show ();
                pd.dismiss ();
                return;
            }

            Client Client = new Client ();
            Service apiService =
                    Client.getClient ().create ( Service.class );
            final Call<MoviesResponse> call = apiService.getTopRatedMovies ();
            call.enqueue ( new Callback<MoviesResponse> () {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    List<Movie> movies =  response.body ().getResults ();
                    recyclerView.setAdapter ( new MoviesAdapter (getApplicationContext (), movies) );
                    recyclerView.smoothScrollToPosition ( 0 );
                    if (swipeContainer.isRefreshing ()){
                        swipeContainer.setRefreshing ( false );
                    }
                    pd.dismiss ();
                }

                @Override
                public void onFailure(retrofit2.Call<MoviesResponse> call, Throwable t) {
                    Log.d ("Error", t.getMessage ());
                    Toast.makeText ( MainActivity.this, "Error ¡No se pueden cargar las peliculas!", Toast.LENGTH_SHORT ).show ();
                }
            } );
        }catch (Exception e){
            Log.d ( "Error", e.getMessage () );
            Toast.makeText ( this, e.toString (), Toast.LENGTH_SHORT ).show ();
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater ().inflate ( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId ()){
            case R.id.menu_settings:
                Intent intent = new Intent ( this, SettingsActivity.class );
                startActivity ( intent );
                return true;
            default:
                return super.onOptionsItemSelected ( item );
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s){
        Log.d ( LOG_TAG, "Ajustes actualizados" );
        checkSortOrder();
    }
    private void checkSortOrder(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences ( this );
        String sortOrder = preferences.getString (
                this.getString ( R.string.pref_sort_order_key ),
                this.getString ( R.string.pref_most_popular )
        );
        if (sortOrder.equals ( this.getString ( R.string.pref_most_popular ) )){
            Log.d ( LOG_TAG, "Ordenando por más populares" );
            loadJSON ();
        }
        else{
            Log.d ( LOG_TAG, "Ordenando por valoración media" );
            loadJSON1 ();
        }
    }

    @Override
    public void onResume(){
        super.onResume ();
        if (movieList.isEmpty ()){
            checkSortOrder ();
        }
    }
}
