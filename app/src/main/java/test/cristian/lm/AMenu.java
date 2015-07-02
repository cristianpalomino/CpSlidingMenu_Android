package test.cristian.lm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cristian on 2/07/15.
 */
public class AMenu extends BaseAdapter {

    private Context context;
    private ArrayList<Menu> menus;
    private LayoutInflater inflater;

    public AMenu(Context context, ArrayList<Menu> menus) {
        this.context = context;
        this.menus = menus;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        Menu menu = menus.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_menu, parent, false);
            holder = new Holder();

            holder.name = (TextView) convertView.findViewById(R.id.name_menu);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name.setText(menu.getName());

        return convertView;
    }

    class Holder {
        TextView name;
    }
}
