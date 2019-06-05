package com.guoshi.module_home.databinding;
import com.guoshi.module_home.R;
import com.guoshi.module_home.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BackProductItemBindingImpl extends BackProductItemBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.itemlin1, 8);
        sViewsWithIds.put(R.id.bankview, 9);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BackProductItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private BackProductItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[7]
            , (android.view.View) bindings[9]
            , (android.widget.LinearLayout) bindings[8]
            );
        this.backname.setTag(null);
        this.backproductname.setTag(null);
        this.bankisHot.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
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
        if (BR.backproduct == variableId) {
            setBackproduct((com.guoshi.baselib.entity.back.BackProducts) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBackproduct(@Nullable com.guoshi.baselib.entity.back.BackProducts Backproduct) {
        this.mBackproduct = Backproduct;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.backproduct);
        super.requestRebind();
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
        com.guoshi.baselib.entity.back.BackProducts backproduct = mBackproduct;
        java.lang.String backproductBankName = null;
        java.lang.String backproductName = null;
        int androidDatabindingViewDataBindingSafeUnboxBackproductIsHot = 0;
        java.lang.String backproductRate = null;
        java.lang.String backproductLimit = null;
        boolean backproductIsHotInt1 = false;
        int backproductIsHotInt1Int0Int8 = 0;
        java.lang.Integer backproductIsHot = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (backproduct != null) {
                    // read backproduct.bankName
                    backproductBankName = backproduct.getBankName();
                    // read backproduct.name
                    backproductName = backproduct.getName();
                    // read backproduct.rate
                    backproductRate = backproduct.getRate();
                    // read backproduct.limit
                    backproductLimit = backproduct.getLimit();
                    // read backproduct.isHot
                    backproductIsHot = backproduct.getIsHot();
                }


                // read android.databinding.ViewDataBinding.safeUnbox(backproduct.isHot)
                androidDatabindingViewDataBindingSafeUnboxBackproductIsHot = android.databinding.ViewDataBinding.safeUnbox(backproductIsHot);


                // read android.databinding.ViewDataBinding.safeUnbox(backproduct.isHot) == 1
                backproductIsHotInt1 = (androidDatabindingViewDataBindingSafeUnboxBackproductIsHot) == (1);
            if((dirtyFlags & 0x3L) != 0) {
                if(backproductIsHotInt1) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read android.databinding.ViewDataBinding.safeUnbox(backproduct.isHot) == 1 ? 0 : 8
                backproductIsHotInt1Int0Int8 = ((backproductIsHotInt1) ? (0) : (8));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.backname, backproductBankName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.backproductname, backproductName);
            this.bankisHot.setVisibility(backproductIsHotInt1Int0Int8);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, backproductRate);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, backproductLimit);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, backproductLimit);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, backproductLimit);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): backproduct
        flag 1 (0x2L): null
        flag 2 (0x3L): android.databinding.ViewDataBinding.safeUnbox(backproduct.isHot) == 1 ? 0 : 8
        flag 3 (0x4L): android.databinding.ViewDataBinding.safeUnbox(backproduct.isHot) == 1 ? 0 : 8
    flag mapping end*/
    //end
}