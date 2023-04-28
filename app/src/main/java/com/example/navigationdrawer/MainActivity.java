package com.example.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura barra de navegação
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Cria referência de toda a área de NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        /*Cria a referência para a área de navegação - é toda a área que ao clicar no botão das três linhas horizontais no
        canto superior da app, no caso, o botão fica no toolbar.*/
        NavigationView navigationView = findViewById(R.id.nav_view);

        /* Define configurações do NavigationDrawer */
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        /*Configura área que irá carregar os fragments - é dentro dele que vai ser carregado os conteúdos
        que fica dentro do content_main.xml - o id nav_host_fragment leva a esse layout. */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        /* Exibe toda a área NavigationView quando se clica no botão com as três linhas horizontais no canto superior do
        app. Ou seja configura menu superior de navegação.  */
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configura a navegação para o NavigationView
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar o menu; isso adiciona itens à barra de ação, se estiver presente.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}


/* Anotações:
*
* Vamos criar um item de menu. Na pasta Menu no arquivo 'main.xml' vamos copiar e colar a tag item
* para criar um item de menu 'Sair'. Lembrando que vamos desenvolver usando o xml (aba Text).
*
* Vale ressaltar que o método onCreateOptionsMenu (ActivityMain) é configurar o menu daa toolbar,
* no caso, 'main.xml' e o 'activity_main_drawer.xml' (pasta menu). É possível reparar que o main.xml
* é carregado dentro desse método.
*
* --------------------------------------------
* Dentro do Builder no mAppBarConfiguration é passado os itens de navegação que vai ser utilizado,
* por exxemplo, os itens inicial, galeria, apresentação, ferramentas, compartilhar e enviar.
*
* -------------------------------------------
* A pasta navigation define as navegações dos itens da NavigationView, são os itens inicial, galeria ...
*
* */