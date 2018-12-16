package prueba.jcp.jorge.fragmentosejerciciociclos;
/*
Hector Gasco,Jorte Cerezo
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fragmentoBotones.ComunicacionFragmentoBotones {

    private ArrayList<CicleFlorida> listadoCursos;
    private fragmentoBotones fb;
    private fragmentoNivel fn;
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
        c = new CicleFlorida("EMPRESA", "Superior", "Administración y Finanzas / FP Dual BANKIA", "Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        c = new CicleFlorida("INFORMÀTICA", "Mitjà", "Sistemas Microinformáticos y Redes", "Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Administración de Sistemas Informáticos y en Red", "Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Multiplataforma", "Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Web", "ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* -------------------------------------->
        LLENANDO EL ARRAYLIST DE CICLOS
         <--------------------------------------- */
        creaDades();
        // ------------------------------------------
        btn1 = false;
        btn2=false;
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        //fn = fragmentoBotones.newInstance(btn1,btn2);
        //fb=(fragmentoBotones) fm.findFragmentById(R.id.fragmentoNivel);
        //ft.add(R.id.fragmentoNivel,fn);
        ft.commit();
    }


    @Override
    public ArrayList<CicleFlorida> mostrarCicloDeportes() {
        CicleFlorida f = null;
        ArrayList<CicleFlorida> cursosFiltrados = null;
        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist

        /* -------------------------------------------------------------------->
        Filtramos el ArrayList para saber que son solo los ciclos de DEPORTES
         <--------------------------------------------------------------------- */

        for (int i = 0; i < listadoCursos.size(); i++) {
            if(listadoCursos.get(i).equals("ESPORT")){
            if (f.getFamiliaProfessional().compareTo("ESPORT") == 0) {

                cursosFiltrados.add(f);
            }

                // --------------- COMENATRIO INTUITIVO ----------------------------
                /* ------------------------------------------------------------------------->
                for(int y = 0;y<cursosFiltrados.size();i++){
                if(cursosFiltrados.equals("Mitjà") || cursosFiltrados.equals("Superior")){}                }
                 <--------------------------------------------------------------------------- */


            }
        }
        return cursosFiltrados;
    }

        //for (listadoCursos : cursos)


        // 2.- Averiguar si har de grado medio o superior
        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios



    @Override
    public void mostrarCicloEmpresa() {
        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist
        // 2.- Averiguar si har de grado medio o superior
        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios

    }

    @Override
    public void mostrarCicloInformatica() {
        // 1- filtrar listadoCiclosFlorida (el de Manel) y guardarlo en un nuevo arraylist
        // 2.- Averiguar si har de grado medio o superior
        //3.- iniciar transaccion y cargar el fragmento nivel con los parámetros necesarios

    }


}
