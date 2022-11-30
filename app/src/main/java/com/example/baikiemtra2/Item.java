package com.example.baikiemtra2;

public class Item {
    private String Id;
    private String TenNgonNgu;

    public Item(String id, String tenNgonNgu) {
        Id = id;
        TenNgonNgu = tenNgonNgu;
    }

    public Item() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTenNgonNgu() {
        return TenNgonNgu;
    }

    public void setTenNgonNgu(String tenNgonNgu) {
        TenNgonNgu = tenNgonNgu;
    }
}
