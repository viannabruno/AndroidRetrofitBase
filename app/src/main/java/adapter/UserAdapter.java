package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidretrofitbase.R;

import java.util.List;

import model.Users;

public class UserAdapter extends BaseAdapter {


    Context context;
    List<Users> colecao;
    LayoutInflater inflter;

    public UserAdapter(final Context applicationContext,
                       final List<Users> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }

    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return this.colecao.get(i);
    }

    private Users parsetItem(int i){
        return this.colecao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.user, viewGroup, false);
        }

        // pega o objeto corrente da lista
        Users user = parsetItem(i);

        //popular os dados do seu layout, utilizando JAVA.

        TextView campoid, campo1, campo2;


        campoid = view.findViewById(R.id.txtId);
        campo1 = view.findViewById(R.id.txt1);
        campo2 = view.findViewById(R.id.txt2);

        campoid.setText(user.getId() + "");
        campo1.setText(user.getName());
        campo2.setText(user.getUsername());

        return view;
    }
}