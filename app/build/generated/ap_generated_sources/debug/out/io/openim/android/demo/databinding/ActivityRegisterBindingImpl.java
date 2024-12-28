package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegisterBindingImpl extends ActivityRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 4);
        sViewsWithIds.put(R.id.title, 5);
        sViewsWithIds.put(R.id.tips, 6);
        sViewsWithIds.put(R.id.clear, 7);
        sViewsWithIds.put(R.id.submit, 8);
        sViewsWithIds.put(R.id.protocolLy, 9);
        sViewsWithIds.put(R.id.protocol, 10);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edt1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of LoginVM.account.getValue()
            //         is LoginVM.account.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edt1);
            // localize variables for thread safety
            // LoginVM
            io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
            // LoginVM.account
            io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMAccount = null;
            // LoginVM.account.getValue()
            java.lang.String loginVMAccountGetValue = null;
            // LoginVM != null
            boolean loginVMJavaLangObjectNull = false;
            // LoginVM.account != null
            boolean loginVMAccountJavaLangObjectNull = false;



            loginVMJavaLangObjectNull = (loginVM) != (null);
            if (loginVMJavaLangObjectNull) {


                loginVMAccount = loginVM.account;

                loginVMAccountJavaLangObjectNull = (loginVMAccount) != (null);
                if (loginVMAccountJavaLangObjectNull) {




                    loginVMAccount.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[7]
            , (com.hbb20.CountryCodePicker) bindings[1]
            , (android.view.View) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.CheckBox) bindings[10]
            , (android.widget.LinearLayout) bindings[9]
            , (androidx.appcompat.widget.AppCompatButton) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            );
        this.countryCode.setTag(null);
        this.divider.setTag(null);
        this.edt1.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.LoginVM == variableId) {
            setLoginVM((io.openim.android.demo.vm.LoginVM) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginVM(@Nullable io.openim.android.demo.vm.LoginVM LoginVM) {
        this.mLoginVM = LoginVM;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.LoginVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginVMAccount((io.openim.android.ouicore.base.vm.State<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLoginVMIsPhone((io.openim.android.ouicore.base.vm.State<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginVMAccount(io.openim.android.ouicore.base.vm.State<java.lang.String> LoginVMAccount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginVMIsPhone(io.openim.android.ouicore.base.vm.State<java.lang.Boolean> LoginVMIsPhone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        boolean androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue = false;
        io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
        io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMAccount = null;
        java.lang.String loginVMAccountGetValue = null;
        java.lang.Boolean loginVMIsPhoneGetValue = null;
        int loginVMIsPhoneViewVISIBLEViewGONE = 0;
        io.openim.android.ouicore.base.vm.State<java.lang.Boolean> loginVMIsPhone = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (loginVM != null) {
                        // read LoginVM.account
                        loginVMAccount = loginVM.account;
                    }
                    updateLiveDataRegistration(0, loginVMAccount);


                    if (loginVMAccount != null) {
                        // read LoginVM.account.getValue()
                        loginVMAccountGetValue = loginVMAccount.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (loginVM != null) {
                        // read LoginVM.isPhone
                        loginVMIsPhone = loginVM.isPhone;
                    }
                    updateLiveDataRegistration(1, loginVMIsPhone);


                    if (loginVMIsPhone != null) {
                        // read LoginVM.isPhone.getValue()
                        loginVMIsPhoneGetValue = loginVMIsPhone.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(LoginVM.isPhone.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue = androidx.databinding.ViewDataBinding.safeUnbox(loginVMIsPhoneGetValue);
                if((dirtyFlags & 0xeL) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(LoginVM.isPhone.getValue()) ? View.VISIBLE : View.GONE
                    loginVMIsPhoneViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.countryCode.setVisibility(loginVMIsPhoneViewVISIBLEViewGONE);
            this.divider.setVisibility(loginVMIsPhoneViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edt1, loginVMAccountGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edt1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edt1androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): LoginVM.account
        flag 1 (0x2L): LoginVM.isPhone
        flag 2 (0x3L): LoginVM
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(LoginVM.isPhone.getValue()) ? View.VISIBLE : View.GONE
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(LoginVM.isPhone.getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}