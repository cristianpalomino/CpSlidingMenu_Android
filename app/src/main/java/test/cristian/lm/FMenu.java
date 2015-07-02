package test.cristian.lm;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FMenu extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listaMenu;
    private AMenu aMenu;
    private OnMenuItemClick onMenuItemClick;

    public static FMenu newInstance() {
        FMenu fragment = new FMenu();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listaMenu = (ListView) getView().findViewById(R.id.lista_menu);
        aMenu = new AMenu(getActivity(), Datasource.getOptionsMenu());
        listaMenu.setAdapter(aMenu);

        listaMenu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Menu menu = (Menu) parent.getItemAtPosition(position);

        Main main = (Main) getActivity();
        main.getMtitle().setText(menu.getName());

        onMenuItemClick.OnMenuItemClick(menu,view);
        main.getMenu().toggle();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onMenuItemClick = (OnMenuItemClick) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onMenuItemClick = null;
    }
}
