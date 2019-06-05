package com.guoshi.module_home.databinding;
import com.guoshi.module_home.R;
import com.guoshi.module_home.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPublicMainBindingImpl extends ActivityPublicMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.publictop, 1);
        sViewsWithIds.put(R.id.publicsearchview, 2);
        sViewsWithIds.put(R.id.publicmainsou, 3);
        sViewsWithIds.put(R.id.publicoka, 4);
        sViewsWithIds.put(R.id.historylin, 5);
        sViewsWithIds.put(R.id.history, 6);
        sViewsWithIds.put(R.id.publichistorydelete, 7);
        sViewsWithIds.put(R.id.publichistoryHotRecyclerView, 8);
        sViewsWithIds.put(R.id.hottext, 9);
        sViewsWithIds.put(R.id.HotRecyclerView, 10);
        sViewsWithIds.put(R.id.publicokb, 11);
        sViewsWithIds.put(R.id.publicmaintablayout, 12);
        sViewsWithIds.put(R.id.publicmainviewpager, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPublicMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityPublicMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.support.v7.widget.RecyclerView) bindings[10]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.RadioButton) bindings[9]
            , (android.support.v7.widget.RecyclerView) bindings[8]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.support.design.widget.TabLayout) bindings[12]
            , (android.support.v4.view.ViewPager) bindings[13]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[11]
            , (android.support.v7.widget.SearchView) bindings[2]
            , (android.view.View) bindings[1]
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