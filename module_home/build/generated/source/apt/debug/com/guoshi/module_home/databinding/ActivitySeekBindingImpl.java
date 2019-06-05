package com.guoshi.module_home.databinding;
import com.guoshi.module_home.R;
import com.guoshi.module_home.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySeekBindingImpl extends ActivitySeekBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.seektop, 1);
        sViewsWithIds.put(R.id.resouview, 2);
        sViewsWithIds.put(R.id.hottext, 3);
        sViewsWithIds.put(R.id.HotRecyclerView, 4);
        sViewsWithIds.put(R.id.historylin, 5);
        sViewsWithIds.put(R.id.history, 6);
        sViewsWithIds.put(R.id.historydelete, 7);
        sViewsWithIds.put(R.id.historyHotRecyclerView, 8);
        sViewsWithIds.put(R.id.ldl, 9);
        sViewsWithIds.put(R.id.SmartRefresh, 10);
        sViewsWithIds.put(R.id.seekokview, 11);
        sViewsWithIds.put(R.id.rv, 12);
        sViewsWithIds.put(R.id.ldlpublic, 13);
        sViewsWithIds.put(R.id.publicRecyclerView, 14);
        sViewsWithIds.put(R.id.intopubliclist, 15);
        sViewsWithIds.put(R.id.ldlprivate, 16);
        sViewsWithIds.put(R.id.privateRecyclerView, 17);
        sViewsWithIds.put(R.id.intoprivatelist, 18);
        sViewsWithIds.put(R.id.yinview, 19);
        sViewsWithIds.put(R.id.bankgengduo, 20);
        sViewsWithIds.put(R.id.ldlbank, 21);
        sViewsWithIds.put(R.id.bankRecyclerView, 22);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySeekBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ActivitySeekBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.v7.widget.RecyclerView) bindings[4]
            , (com.scwang.smartrefresh.layout.SmartRefreshLayout) bindings[10]
            , (android.support.v7.widget.RecyclerView) bindings[22]
            , (android.widget.TextView) bindings[20]
            , (android.widget.RadioButton) bindings[6]
            , (android.support.v7.widget.RecyclerView) bindings[8]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.RadioButton) bindings[3]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[15]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[9]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[21]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[16]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[13]
            , (android.support.v7.widget.RecyclerView) bindings[17]
            , (android.support.v7.widget.RecyclerView) bindings[14]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ScrollView) bindings[11]
            , (android.view.View) bindings[1]
            , (android.widget.TextView) bindings[19]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.sa == variableId) {
            setSa((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSa(@Nullable java.lang.String Sa) {
        this.mSa = Sa;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): sa
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}