package prueba.jcp.jorge.fragmentosejerciciociclos;
/*
Hector Gasco,Jorte Cerezo
 */

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fragmentoBotones.ComunicacionFragmentoBotones,fragmentoNivel.comunicaTipoNivel{

    private ArrayList<CicleFlorida> listadoCursos;
    private fragmentoBotones fb;
    private fragmentoNivel fn;
    private FragmentoListado fl;
    private FragmentManager fm;
    private FragmentTransaction ft;
    Boolean btn1,btn2;

    public void creaDades() {
        CicleFlorida c;


        c = new CicleFlorida("ESPORT", "Superior", "Animació d'activitats físiques i esportives", "Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        listadoCursos.add(c);
        c = new CicleFlorida("ESPORT", "Mitjà", "Conducción de actividades físico deportivas en el medio natural", "Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        listadoCursos.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Gestión de Ventas y Espacios Comerciales", "Nuevo ciclo formativo de grado superior concertado por la GVA");
        listadoCursos.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Marketing y publicidad", "Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        listadoCursos.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Administración y Finanzas / FP Dual BANKIA", "Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        listadoCursos.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Mitjà", "Sistemas Microinformáticos y Redes", "Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        listadoCursos.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Administración de Sistemas Informáticos y en Red", "Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        listadoCursos.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Multiplataforma", "Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        listadoCursos.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Web", "ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        listadoCursos.add(c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* -------------------------------------->
        LLENANDO EL ARRAYLIST DE CICLOS
         <--------------------------------------- */
        listadoCursos = new ArrayList<CicleFlorida>();
        creaDades();
        // ------------------------------------------
        btn1 = false;
        btn2=false;
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        //fn = fragmentoBotones.newInstance(btn1,btn2);
        //fb=(fragmentoBotones) fm.findFragmentById(R.id.fragmentoNivel);
        //ft.add(R.id.fragmentoNivel,fn);
        ft.commit();
    }


    public ArrayList<CicleFlorida> filtrarTitulacion(String titulacion){
        CicleFlorida f =null;
        ArrayList<CicleFlorida> cursosFiltradosPorTitulacion = new ArrayList<CicleFlorida>();

        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist

        /* -------------------------------------------------------------------->
        Filtramos el ArrayList para saber que son solo los ciclos de DEPORTES
         <--------------------------------------------------------------------- */

        for (int i = 0; i < listadoCursos.size(); i++) {
            f = listadoCursos.get(i);
            if (f.getFamiliaProfessional().compareTo(titulacion) == 0) {

                cursosFiltradosPorTitulacion.add(f);
            }
        }



     /* El mateix  fet amb un foreach ----
        for(CicleFlorida unElemento:listadoCursos) {
            if (unElemento.getFamiliaProfessional().compareTo("ESPORT") == 0) {
                cursosFiltradosDeportes.add(unElemento);
            }
        }

        */
     return cursosFiltradosPorTitulacion;
    }
    public int numeroBotones(ArrayList<CicleFlorida> unListado){
        boolean hayMitja=false, haySuperior=false ;
        int resultado=0;

        for(CicleFlorida unElemento:unListado)
        {
            if(unElemento.getTipus().compareTo("Mitjà")==0){
                hayMitja=true;
            }
            if(unElemento.getTipus().compareTo("Superior")==0) {
                haySuperior = true;
            }
        }
        if(hayMitja&&haySuperior) resultado=3;
        if(hayMitja&&!haySuperior) resultado=1;
        if(!hayMitja&&haySuperior) resultado=2;

        return resultado;
    }
    @Override
    public void mostrarCicloDeportes() {
        ArrayList<CicleFlorida> listadoFiltradoPorTitulacion;
        int numeroBotones=0;
        listadoFiltradoPorTitulacion=filtrarTitulacion("ESPORT");

        // 2.- Averiguar si hay de grado medio o superior

        numeroBotones=numeroBotones(listadoFiltradoPorTitulacion);

        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios
        //Creamos el fragmentoNivel
        fn=fragmentoNivel.newInstanceNivel(listadoFiltradoPorTitulacion,numeroBotones);
        //4.- mostramos ese fragmento en el main activity
        ft=fm.beginTransaction();
        ft.replace(R.id.fragment_nivell,fn);
        ft.commit();
    }









    @Override
    public void mostrarCicloEmpresa() {
        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist
        // 2.- Averiguar si har de grado medio o superior
        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios
        ArrayList<CicleFlorida> listadoFiltradoPorTitulacion;
        int numeroBotones=0;
        listadoFiltradoPorTitulacion=filtrarTitulacion("EMPRESA");

        // 2.- Averiguar si hay de grado medio o superior

        numeroBotones=numeroBotones(listadoFiltradoPorTitulacion);

        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios
        //Creamos el fragmentoNivel
        fn=fragmentoNivel.newInstanceNivel(listadoFiltradoPorTitulacion,numeroBotones);
        //4.- mostramos ese fragmento en el main activity
        ft=fm.beginTransaction();
        ft.replace(R.id.fragment_nivell,fn);
        ft.commit();

    }

    @Override
    public void mostrarCicloInformatica() {
        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist
        // 2.- Averiguar si har de grado medio o superior
        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios
        ArrayList<CicleFlorida> listadoFiltradoPorTitulacion;
        int numeroBotones=0;
        listadoFiltradoPorTitulacion=filtrarTitulacion("INFORMÀTICA");

        // 2.- Averiguar si hay de grado medio o superior

        numeroBotones=numeroBotones(listadoFiltradoPorTitulacion);

        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios
        //Creamos el fragmentoNivel
        fn=fragmentoNivel.newInstanceNivel(listadoFiltradoPorTitulacion,numeroBotones);
        //4.- mostramos ese fragmento en el main activity
        ft=fm.beginTransaction();
        ft.replace(R.id.fragment_nivell,fn);
        ft.commit();


    }


    @Override
    public void filtrarTipoNivel(String nivel,ArrayList<CicleFlorida> listado) {
        ArrayList<CicleFlorida> arrayFiltradoPorNivel=new ArrayList<CicleFlorida>();

        for(CicleFlorida unElemento:listado){
            if (unElemento.getTipus().compareTo(nivel)==0){
                arrayFiltradoPorNivel.add(unElemento);
            }
        }
        //creamos el fragment3
        fl= FragmentoListado.newInstance(arrayFiltradoPorNivel);

        //Mostramos
        ft=fm.beginTransaction();
        ft.replace(R.id.fragment_llistat,fl);
        ft.commit();
    }
}
