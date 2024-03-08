package com.ltrsoft.userpoliceapp.ui;

import java.util.ArrayList;
public class GetLists {
        public static ArrayList<String>getListByTag(String tag){
            ArrayList<String>list=new ArrayList<>();
            switch (tag){
                case FormElement.SYBTYPE_SPINNER_STATION:
                    list.add("latur");
                    list.add("aurangabad");
                    list.add("nilanga");
                    list.add("parbhai");
                    list.add("latur");
            }
            return list;
        }
}
