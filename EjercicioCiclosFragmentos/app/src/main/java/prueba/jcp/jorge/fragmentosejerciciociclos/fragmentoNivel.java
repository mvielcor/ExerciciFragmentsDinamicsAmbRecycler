package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;



public class fragmentoNivel extends Fragment implements View.OnClickListener {
    private static final String LISTADO_CICLOS_FILTRADO = "llistat Cicles Filtrat";
    private static final String NUM_BOTONES_NIVEL = "num botons de nivell";
    private Button btnMedio;
    private Button btnSuperior;
    private ArrayList<CicleFlorida> arrayRecibidoPorParametro;
    private int numBotonsRecibidoPorParametro;

    private comunicaTipoNivel comunicador;
    /*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    */

    public fragmentoNivel() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragmentoNivel newInstanceNivel(ArrayList<CicleFlorida> llistat, int numBotons ) {
        fragmentoNivel fragment = new fragmentoNivel();
        Bundle args = new Bundle();
        args.putParcelableArrayList(LISTADO_CICLOS_FILTRADO, llistat);
        args.putInt(NUM_BOTONES_NIVEL, numBotons);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            //Recogeremos los parámetros recibidos por el Bundle y los guardaremos en atributos de esta clase
            Bundle b = getArguments();
            arrayRecibidoPorParametro=b.getParcelableArrayList(LISTADO_CICLOS_FILTRADO);
            numBotonsRecibidoPorParametro=b.getInt(NUM_BOTONES_NIVEL);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_fragmento_nivel, container, false);
        btnMedio= v.findViewById(R.id.btnMedio);
        btnSuperior= v.findViewById(R.id.btnSuperior);

        btnMedio.setOnClickListener(this);
        btnSuperior.setOnClickListener(this);

        if(numBotonsRecibidoPorParametro==1){
            btnMedio.setEnabled(true);
            btnSuperior.setEnabled(false);
        }
        if(numBotonsRecibidoPorParametro==2){
            btnMedio.setEnabled(false);
            btnSuperior.setEnabled(true);
        }
        if(numBotonsRecibidoPorParametro==3){
            btnMedio.setEnabled(true);
            btnSuperior.setEnabled(true);
        }


        return v;
    }

   @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       if (context instanceof comunicaTipoNivel) {
            comunicador = (comunicaTipoNivel) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
      comunicador = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnMedio){
            comunicador.filtrarTipoNivel("Mitjà",arrayRecibidoPorParametro);
        }if(view.getId()==R.id.btnSuperior){
            comunicador.filtrarTipoNivel("Superior",arrayRecibidoPorParametro);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
  public interface comunicaTipoNivel {
        // TODO: Update argument type and name
        void filtrarTipoNivel(String nivel,ArrayList<CicleFlorida> lista);
    }

}
