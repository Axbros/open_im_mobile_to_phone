package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityServerConfigBindingImpl extends ActivityServerConfigBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 4);
        sViewsWithIds.put(R.id.swDomain, 5);
        sViewsWithIds.put(R.id.swIP, 6);
        sViewsWithIds.put(R.id.head, 7);
        sViewsWithIds.put(R.id.restart, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.HEAD.getValue()
            //         is serverConfigVM.HEAD.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // serverConfigVM.HEAD != null
            boolean serverConfigVMHEADJavaLangObjectNull = false;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
            // serverConfigVM.HEAD
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMHEAD = null;
            // serverConfigVM.HEAD.getValue()
            java.lang.String serverConfigVMHEADGetValue = null;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMHEAD = serverConfigVM.HEAD;

                serverConfigVMHEADJavaLangObjectNull = (serverConfigVMHEAD) != (null);
                if (serverConfigVMHEADJavaLangObjectNull) {




                    serverConfigVMHEAD.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityServerConfigBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityServerConfigBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (bindings[4] != null) ? io.openim.android.ouicore.databinding.ViewBackBinding.bind((android.view.View) bindings[4]) : null
            , (android.widget.TextView) bindings[7]
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[5]
            , (android.widget.Button) bindings[6]
            , (android.widget.Switch) bindings[3]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.switchControl.setTag(null);
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
        if (BR.serverConfigVM == variableId) {
            setServerConfigVM((io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setServerConfigVM(@Nullable io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM ServerConfigVM) {
        this.mServerConfigVM = ServerConfigVM;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.serverConfigVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeServerConfigVMHEAD((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeServerConfigVMISADMIN((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeServerConfigVMHEAD(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMHEAD, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMISADMIN(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ServerConfigVMISADMIN, int fieldId) {
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
        boolean androidxDatabindingViewDataBindingSafeUnboxServerConfigVMISADMINGetValue = false;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMHEAD = null;
        java.lang.String serverConfigVMHEADGetValue = null;
        io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> serverConfigVMISADMIN = null;
        java.lang.Boolean serverConfigVMISADMINGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.HEAD
                        serverConfigVMHEAD = serverConfigVM.HEAD;
                    }
                    updateLiveDataRegistration(0, serverConfigVMHEAD);


                    if (serverConfigVMHEAD != null) {
                        // read serverConfigVM.HEAD.getValue()
                        serverConfigVMHEADGetValue = serverConfigVMHEAD.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.IS_ADMIN
                        serverConfigVMISADMIN = serverConfigVM.IS_ADMIN;
                    }
                    updateLiveDataRegistration(1, serverConfigVMISADMIN);


                    if (serverConfigVMISADMIN != null) {
                        // read serverConfigVM.IS_ADMIN.getValue()
                        serverConfigVMISADMINGetValue = serverConfigVMISADMIN.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(serverConfigVM.IS_ADMIN.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxServerConfigVMISADMINGetValue = androidx.databinding.ViewDataBinding.safeUnbox(serverConfigVMISADMINGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, serverConfigVMHEADGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.switchControl, androidxDatabindingViewDataBindingSafeUnboxServerConfigVMISADMINGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): serverConfigVM.HEAD
        flag 1 (0x2L): serverConfigVM.IS_ADMIN
        flag 2 (0x3L): serverConfigVM
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}