package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(2, 
            new String[] {"layout_login"},
            new int[] {6},
            new int[] {io.openim.android.demo.R.layout.layout_login});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.welcome, 7);
        sViewsWithIds.put(R.id.phoneTv, 8);
        sViewsWithIds.put(R.id.phoneVv, 9);
        sViewsWithIds.put(R.id.mailTv, 10);
        sViewsWithIds.put(R.id.mailVv, 11);
        sViewsWithIds.put(R.id.submit, 12);
        sViewsWithIds.put(R.id.protocol, 13);
        sViewsWithIds.put(R.id.version, 14);
        sViewsWithIds.put(R.id.registerTv, 15);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView11;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[4]
            , (io.openim.android.demo.databinding.LayoutLoginBinding) bindings[6]
            , (android.widget.TextView) bindings[10]
            , (android.view.View) bindings[11]
            , (android.widget.TextView) bindings[8]
            , (android.view.View) bindings[9]
            , (android.widget.CheckBox) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[7]
            );
        this.changeLoginType.setTag(null);
        setContainedBinding(this.loginContent);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (bindings[5] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[5]) : null;
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        loginContent.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (loginContent.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.loginVM == variableId) {
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
        notifyPropertyChanged(BR.loginVM);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        loginContent.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginContent((io.openim.android.demo.databinding.LayoutLoginBinding) object, fieldId);
            case 1 :
                return onChangeLoginVMIsPhone((io.openim.android.ouicore.base.vm.State<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginContent(io.openim.android.demo.databinding.LayoutLoginBinding LoginContent, int fieldId) {
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
        java.lang.String loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLogin = null;
        java.lang.String loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLogin = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue = false;
        java.lang.Boolean loginVMIsPhoneGetValue = null;
        io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
        io.openim.android.ouicore.base.vm.State<java.lang.Boolean> loginVMIsPhone = null;

        if ((dirtyFlags & 0xeL) != 0) {



                if (loginVM != null) {
                    // read loginVM.isPhone
                    loginVMIsPhone = loginVM.isPhone;
                }
                updateLiveDataRegistration(1, loginVMIsPhone);


                if (loginVMIsPhone != null) {
                    // read loginVM.isPhone.getValue()
                    loginVMIsPhoneGetValue = loginVMIsPhone.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue())
                androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue = androidx.databinding.ViewDataBinding.safeUnbox(loginVMIsPhoneGetValue);
            if((dirtyFlags & 0xeL) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login)
                loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLogin = ((androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue) ? (io.openim.android.ouicore.base.BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login)) : (io.openim.android.ouicore.base.BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login)));
                // read androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login)
                loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLogin = ((androidxDatabindingViewDataBindingSafeUnboxLoginVMIsPhoneGetValue) ? (io.openim.android.ouicore.base.BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login)) : (io.openim.android.ouicore.base.BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login)));
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.changeLoginType, loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLogin);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, loginVMIsPhoneBaseAppInstGetStringIoOpenimAndroidOuicoreRStringPhoneLoginBaseAppInstGetStringIoOpenimAndroidOuicoreRStringEmailLogin);
        }
        executeBindingsOn(loginContent);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginContent
        flag 1 (0x2L): loginVM.isPhone
        flag 2 (0x3L): loginVM
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login)
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login)
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login)
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(loginVM.isPhone.getValue()) ? BaseApp.inst().getString(io.openim.android.ouicore.R.string.email_login) : BaseApp.inst().getString(io.openim.android.ouicore.R.string.phone_login)
    flag mapping end*/
    //end
}