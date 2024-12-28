package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySupplementInfoBindingImpl extends ActivitySupplementInfoBinding implements io.openim.android.demo.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 4);
        sViewsWithIds.put(R.id.surePassword, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener nickNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of LoginVM.nickName.getValue()
            //         is LoginVM.nickName.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(nickName);
            // localize variables for thread safety
            // LoginVM
            io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
            // LoginVM.nickName.getValue()
            java.lang.String loginVMNickNameGetValue = null;
            // LoginVM.nickName
            io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMNickName = null;
            // LoginVM != null
            boolean loginVMJavaLangObjectNull = false;
            // LoginVM.nickName != null
            boolean loginVMNickNameJavaLangObjectNull = false;



            loginVMJavaLangObjectNull = (loginVM) != (null);
            if (loginVMJavaLangObjectNull) {


                loginVMNickName = loginVM.nickName;

                loginVMNickNameJavaLangObjectNull = (loginVMNickName) != (null);
                if (loginVMNickNameJavaLangObjectNull) {




                    loginVMNickName.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener passwordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of LoginVM.pwd.getValue()
            //         is LoginVM.pwd.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(password);
            // localize variables for thread safety
            // LoginVM.pwd != null
            boolean loginVMPwdJavaLangObjectNull = false;
            // LoginVM
            io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
            // LoginVM.pwd
            io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMPwd = null;
            // LoginVM.pwd.getValue()
            java.lang.String loginVMPwdGetValue = null;
            // LoginVM != null
            boolean loginVMJavaLangObjectNull = false;



            loginVMJavaLangObjectNull = (loginVM) != (null);
            if (loginVMJavaLangObjectNull) {


                loginVMPwd = loginVM.pwd;

                loginVMPwdJavaLangObjectNull = (loginVMPwd) != (null);
                if (loginVMPwdJavaLangObjectNull) {




                    loginVMPwd.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivitySupplementInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivitySupplementInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.ImageView) bindings[4]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[2]
            , (android.widget.Button) bindings[3]
            , (android.widget.EditText) bindings[5]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nickName.setTag(null);
        this.password.setTag(null);
        this.submit.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new io.openim.android.demo.generated.callback.OnClickListener(this, 1);
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
                return onChangeLoginVMPwd((io.openim.android.ouicore.base.vm.State<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLoginVMNickName((io.openim.android.ouicore.base.vm.State<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginVMPwd(io.openim.android.ouicore.base.vm.State<java.lang.String> LoginVMPwd, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginVMNickName(io.openim.android.ouicore.base.vm.State<java.lang.String> LoginVMNickName, int fieldId) {
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
        io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
        java.lang.String loginVMNickNameGetValue = null;
        java.lang.String loginVMPwdGetValue = null;
        io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMPwd = null;
        io.openim.android.ouicore.base.vm.State<java.lang.String> loginVMNickName = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (loginVM != null) {
                        // read LoginVM.pwd
                        loginVMPwd = loginVM.pwd;
                    }
                    updateLiveDataRegistration(0, loginVMPwd);


                    if (loginVMPwd != null) {
                        // read LoginVM.pwd.getValue()
                        loginVMPwdGetValue = loginVMPwd.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (loginVM != null) {
                        // read LoginVM.nickName
                        loginVMNickName = loginVM.nickName;
                    }
                    updateLiveDataRegistration(1, loginVMNickName);


                    if (loginVMNickName != null) {
                        // read LoginVM.nickName.getValue()
                        loginVMNickNameGetValue = loginVMNickName.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nickName, loginVMNickNameGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.nickName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, nickNameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.password, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, passwordandroidTextAttrChanged);
            this.submit.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.password, loginVMPwdGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // LoginVM
        io.openim.android.demo.vm.LoginVM loginVM = mLoginVM;
        // LoginVM != null
        boolean loginVMJavaLangObjectNull = false;



        loginVMJavaLangObjectNull = (loginVM) != (null);
        if (loginVMJavaLangObjectNull) {


            loginVM.register();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): LoginVM.pwd
        flag 1 (0x2L): LoginVM.nickName
        flag 2 (0x3L): LoginVM
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}