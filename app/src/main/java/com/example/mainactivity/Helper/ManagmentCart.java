package com.example.mainactivity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.mainactivity.Domain.PopularDomain;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void instertFood(PopularDomain item){
        ArrayList<PopularDomain> listPop = getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i=0; i<listPop.size(); i++) {
            if (listPop.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = 1;
                break;
            }
        }

        if (existAlready) {
            listPop.get(n).setNumberinCart(item.getNumberinCart());
        }else {
            listPop.add(item);
        }
        tinyDB.putListObject("CartList", listPop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberItem(ArrayList<PopularDomain>listItem,int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listItem.get(position).getNumberinCart()==1){
            listItem.remove(position);

        }else {
            listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart()-1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.change();
    }

    public void plusNumberItem(ArrayList<PopularDomain>listItem,int position, ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart()+1);
        tinyDB.putListObject("CarList", listItem);
        changeNumberItemsListener.change();
    }

    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem=getListCart();
        double fee=0;
        for (int i = 0; i < listItem.size(); i++) {
            fee = fee+(listItem.get(i).getPrice()*listItem.get(i).getNumberinCart())
        }
        return fee;
    }

}
