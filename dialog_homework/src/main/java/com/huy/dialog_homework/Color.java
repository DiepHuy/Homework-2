package com.huy.dialog_homework;

import java.io.Serializable;

public class Color implements Serializable {
    private  boolean isChecked;
    private int resourceId;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Color(int resourceId, boolean isChecked) {
        this.resourceId = resourceId;
        this.isChecked = isChecked;
    }
}
