package com.retrofit_example.anddevolver.geniusplaza.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse {
    @SerializedName("page")
    int mPage;
    @SerializedName("per_page")
    int mPerPage;
    @SerializedName("total_pages")
    int getmTotalPages;
    @SerializedName("total")
    int mTotal;
    @SerializedName("data")
    List<User> mUsers;

    public int getmPage() {
        return mPage;
    }

    public void setmPage(int mPage) {
        this.mPage = mPage;
    }

    public int getmPerPage() {
        return mPerPage;
    }

    public void setmPerPage(int mPerPage) {
        this.mPerPage = mPerPage;
    }

    public int getGetmTotalPages() {
        return getmTotalPages;
    }

    public void setGetmTotalPages(int getmTotalPages) {
        this.getmTotalPages = getmTotalPages;
    }

    public int getmTotal() {
        return mTotal;
    }

    public void setmTotal(int mTotal) {
        this.mTotal = mTotal;
    }

    public List<User> getmUsers() {
        return mUsers;
    }

    public void setmUsers(List<User> mUsers) {
        this.mUsers = mUsers;
    }
}
