package com.guoshi.module_home.databinding;
import com.guoshi.module_home.R;
import com.guoshi.module_home.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAllBindingImpl extends FragmentAllBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.seekokview, 1);
        sViewsWithIds.put(R.id.ldlporduct, 2);
        sViewsWithIds.put(R.id.fund_porductRecyclerView, 3);
        sViewsWithIds.put(R.id.porduct, 4);
        sViewsWithIds.put(R.id.ldlcompany, 5);
        sViewsWithIds.put(R.id.fund_companyRecyclerView, 6);
        sViewsWithIds.put(R.id.company, 7);
        sViewsWithIds.put(R.id.ldlmanger, 8);
        sViewsWithIds.put(R.id.fund_fundmangerRecyclerView, 9);
        sViewsWithIds.put(R.id.fundmanger, 10);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentAllBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentAllBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[7]
            , (android.support.v7.widget.RecyclerView) bindings[6]
            , (android.support.v7.widget.RecyclerView) bindings[9]
            , (android.support.v7.widget.RecyclerView) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[0]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[5]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[8]
            , (com.guoshi.baselib.layout.LoadDataLayout) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ScrollView) bindings[1]
            );
        this.ldl.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}