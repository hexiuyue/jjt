package com.guoshi.module_home.databinding;
import com.guoshi.module_home.R;
import com.guoshi.module_home.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FundMangerItemBindingImpl extends FundMangerItemBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.publicmangericon, 4);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FundMangerItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private FundMangerItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[3]
            );
        this.fundmimg.setTag(null);
        this.fundmname.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.viewgui.setTag(null);
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
        if (BR.funmanger == variableId) {
            setFunmanger((com.guoshi.baselib.entity.fund.FundManger) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFunmanger(@Nullable com.guoshi.baselib.entity.fund.FundManger Funmanger) {
        this.mFunmanger = Funmanger;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.funmanger);
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
        java.lang.String funmangerExperience = null;
        java.lang.String funmangerIcon = null;
        java.lang.String funmangerManagerName = null;
        com.guoshi.baselib.entity.fund.FundManger funmanger = mFunmanger;
        java.lang.String funmangerCompanyNameJavaLangString = null;
        java.lang.String funmangerCompanyName = null;
        java.lang.String funmangerCompanyNameJavaLangStringFunmangerExperience = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (funmanger != null) {
                    // read funmanger.experience
                    funmangerExperience = funmanger.getExperience();
                    // read funmanger.icon
                    funmangerIcon = funmanger.getIcon();
                    // read funmanger.managerName
                    funmangerManagerName = funmanger.getManagerName();
                    // read funmanger.companyName
                    funmangerCompanyName = funmanger.getCompanyName();
                }


                // read (funmanger.companyName) + (" ")
                funmangerCompanyNameJavaLangString = (funmangerCompanyName) + (" ");


                // read ((funmanger.companyName) + (" ")) + (funmanger.experience)
                funmangerCompanyNameJavaLangStringFunmangerExperience = (funmangerCompanyNameJavaLangString) + (funmangerExperience);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.guoshi.baselib.entity.fund.FundManger.getInternetImage(this.fundmimg, funmangerIcon);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.fundmname, funmangerManagerName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.viewgui, funmangerCompanyNameJavaLangStringFunmangerExperience);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): funmanger
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}