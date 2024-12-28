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
        sViewsWithIds.put(R.id.back, 8);
        sViewsWithIds.put(R.id.swDomain, 9);
        sViewsWithIds.put(R.id.swIP, 10);
        sViewsWithIds.put(R.id.head, 11);
        sViewsWithIds.put(R.id.restart, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.EditText mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView6;
    @NonNull
    private final android.widget.EditText mboundView7;
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
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.APP_AUTH_URL.getValue()
            //         is serverConfigVM.APP_AUTH_URL.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // serverConfigVM.APP_AUTH_URL != null
            boolean serverConfigVMAPPAUTHURLJavaLangObjectNull = false;
            // serverConfigVM.APP_AUTH_URL
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMAPPAUTHURL = null;
            // serverConfigVM.APP_AUTH_URL.getValue()
            java.lang.String serverConfigVMAPPAUTHURLGetValue = null;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMAPPAUTHURL = serverConfigVM.APP_AUTH_URL;

                serverConfigVMAPPAUTHURLJavaLangObjectNull = (serverConfigVMAPPAUTHURL) != (null);
                if (serverConfigVMAPPAUTHURLJavaLangObjectNull) {




                    serverConfigVMAPPAUTHURL.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.IM_API_URL.getValue()
            //         is serverConfigVM.IM_API_URL.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // serverConfigVM.IM_API_URL
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMIMAPIURL = null;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
            // serverConfigVM.IM_API_URL.getValue()
            java.lang.String serverConfigVMIMAPIURLGetValue = null;
            // serverConfigVM.IM_API_URL != null
            boolean serverConfigVMIMAPIURLJavaLangObjectNull = false;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMIMAPIURL = serverConfigVM.IM_API_URL;

                serverConfigVMIMAPIURLJavaLangObjectNull = (serverConfigVMIMAPIURL) != (null);
                if (serverConfigVMIMAPIURLJavaLangObjectNull) {




                    serverConfigVMIMAPIURL.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.IM_WS_URL.getValue()
            //         is serverConfigVM.IM_WS_URL.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // serverConfigVM.IM_WS_URL.getValue()
            java.lang.String serverConfigVMIMWSURLGetValue = null;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
            // serverConfigVM.IM_WS_URL
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMIMWSURL = null;
            // serverConfigVM.IM_WS_URL != null
            boolean serverConfigVMIMWSURLJavaLangObjectNull = false;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMIMWSURL = serverConfigVM.IM_WS_URL;

                serverConfigVMIMWSURLJavaLangObjectNull = (serverConfigVMIMWSURL) != (null);
                if (serverConfigVMIMWSURLJavaLangObjectNull) {




                    serverConfigVMIMWSURL.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.STORAGE_TYPE.getValue()
            //         is serverConfigVM.STORAGE_TYPE.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // serverConfigVM.STORAGE_TYPE != null
            boolean serverConfigVMSTORAGETYPEJavaLangObjectNull = false;
            // serverConfigVM.STORAGE_TYPE
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMSTORAGETYPE = null;
            // serverConfigVM.STORAGE_TYPE.getValue()
            java.lang.String serverConfigVMSTORAGETYPEGetValue = null;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMSTORAGETYPE = serverConfigVM.STORAGE_TYPE;

                serverConfigVMSTORAGETYPEJavaLangObjectNull = (serverConfigVMSTORAGETYPE) != (null);
                if (serverConfigVMSTORAGETYPEJavaLangObjectNull) {




                    serverConfigVMSTORAGETYPE.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of serverConfigVM.PARENT_UID.getValue()
            //         is serverConfigVM.PARENT_UID.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // serverConfigVM.PARENT_UID
            androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMPARENTUID = null;
            // serverConfigVM != null
            boolean serverConfigVMJavaLangObjectNull = false;
            // serverConfigVM
            io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
            // serverConfigVM.PARENT_UID != null
            boolean serverConfigVMPARENTUIDJavaLangObjectNull = false;
            // serverConfigVM.PARENT_UID.getValue()
            java.lang.String serverConfigVMPARENTUIDGetValue = null;



            serverConfigVMJavaLangObjectNull = (serverConfigVM) != (null);
            if (serverConfigVMJavaLangObjectNull) {


                serverConfigVMPARENTUID = serverConfigVM.PARENT_UID;

                serverConfigVMPARENTUIDJavaLangObjectNull = (serverConfigVMPARENTUID) != (null);
                if (serverConfigVMPARENTUIDJavaLangObjectNull) {




                    serverConfigVMPARENTUID.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityServerConfigBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityServerConfigBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (bindings[8] != null) ? io.openim.android.ouicore.databinding.ViewBackBinding.bind((android.view.View) bindings[8]) : null
            , (android.widget.TextView) bindings[11]
            , (android.widget.Button) bindings[12]
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[10]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.EditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.EditText) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.EditText) bindings[7];
        this.mboundView7.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.serverConfigVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeServerConfigVMPARENTUID((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeServerConfigVMHEAD((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeServerConfigVMIMAPIURL((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeServerConfigVMAPPAUTHURL((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeServerConfigVMSTORAGETYPE((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeServerConfigVMIMWSURL((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeServerConfigVMPARENTUID(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMPARENTUID, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMHEAD(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMHEAD, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMIMAPIURL(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMIMAPIURL, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMAPPAUTHURL(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMAPPAUTHURL, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMSTORAGETYPE(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMSTORAGETYPE, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeServerConfigVMIMWSURL(androidx.lifecycle.MutableLiveData<java.lang.String> ServerConfigVMIMWSURL, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMPARENTUID = null;
        java.lang.String serverConfigVMIMWSURLGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMHEAD = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMIMAPIURL = null;
        java.lang.String serverConfigVMSTORAGETYPEGetValue = null;
        java.lang.String serverConfigVMPARENTUIDGetValue = null;
        java.lang.String serverConfigVMIMAPIURLGetValue = null;
        java.lang.String serverConfigVMHEADGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMAPPAUTHURL = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMSTORAGETYPE = null;
        java.lang.String serverConfigVMAPPAUTHURLGetValue = null;
        io.openim.android.demo.ui.ServerConfigActivity.ServerConfigVM serverConfigVM = mServerConfigVM;
        androidx.lifecycle.MutableLiveData<java.lang.String> serverConfigVMIMWSURL = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.PARENT_UID
                        serverConfigVMPARENTUID = serverConfigVM.PARENT_UID;
                    }
                    updateLiveDataRegistration(0, serverConfigVMPARENTUID);


                    if (serverConfigVMPARENTUID != null) {
                        // read serverConfigVM.PARENT_UID.getValue()
                        serverConfigVMPARENTUIDGetValue = serverConfigVMPARENTUID.getValue();
                    }
            }
            if ((dirtyFlags & 0xc2L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.HEAD
                        serverConfigVMHEAD = serverConfigVM.HEAD;
                    }
                    updateLiveDataRegistration(1, serverConfigVMHEAD);


                    if (serverConfigVMHEAD != null) {
                        // read serverConfigVM.HEAD.getValue()
                        serverConfigVMHEADGetValue = serverConfigVMHEAD.getValue();
                    }
            }
            if ((dirtyFlags & 0xc4L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.IM_API_URL
                        serverConfigVMIMAPIURL = serverConfigVM.IM_API_URL;
                    }
                    updateLiveDataRegistration(2, serverConfigVMIMAPIURL);


                    if (serverConfigVMIMAPIURL != null) {
                        // read serverConfigVM.IM_API_URL.getValue()
                        serverConfigVMIMAPIURLGetValue = serverConfigVMIMAPIURL.getValue();
                    }
            }
            if ((dirtyFlags & 0xc8L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.APP_AUTH_URL
                        serverConfigVMAPPAUTHURL = serverConfigVM.APP_AUTH_URL;
                    }
                    updateLiveDataRegistration(3, serverConfigVMAPPAUTHURL);


                    if (serverConfigVMAPPAUTHURL != null) {
                        // read serverConfigVM.APP_AUTH_URL.getValue()
                        serverConfigVMAPPAUTHURLGetValue = serverConfigVMAPPAUTHURL.getValue();
                    }
            }
            if ((dirtyFlags & 0xd0L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.STORAGE_TYPE
                        serverConfigVMSTORAGETYPE = serverConfigVM.STORAGE_TYPE;
                    }
                    updateLiveDataRegistration(4, serverConfigVMSTORAGETYPE);


                    if (serverConfigVMSTORAGETYPE != null) {
                        // read serverConfigVM.STORAGE_TYPE.getValue()
                        serverConfigVMSTORAGETYPEGetValue = serverConfigVMSTORAGETYPE.getValue();
                    }
            }
            if ((dirtyFlags & 0xe0L) != 0) {

                    if (serverConfigVM != null) {
                        // read serverConfigVM.IM_WS_URL
                        serverConfigVMIMWSURL = serverConfigVM.IM_WS_URL;
                    }
                    updateLiveDataRegistration(5, serverConfigVMIMWSURL);


                    if (serverConfigVMIMWSURL != null) {
                        // read serverConfigVM.IM_WS_URL.getValue()
                        serverConfigVMIMWSURLGetValue = serverConfigVMIMWSURL.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, serverConfigVMHEADGetValue);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, serverConfigVMAPPAUTHURLGetValue);
        }
        if ((dirtyFlags & 0xc4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, serverConfigVMIMAPIURLGetValue);
        }
        if ((dirtyFlags & 0xe0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, serverConfigVMIMWSURLGetValue);
        }
        if ((dirtyFlags & 0xd0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, serverConfigVMSTORAGETYPEGetValue);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, serverConfigVMPARENTUIDGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): serverConfigVM.PARENT_UID
        flag 1 (0x2L): serverConfigVM.HEAD
        flag 2 (0x3L): serverConfigVM.IM_API_URL
        flag 3 (0x4L): serverConfigVM.APP_AUTH_URL
        flag 4 (0x5L): serverConfigVM.STORAGE_TYPE
        flag 5 (0x6L): serverConfigVM.IM_WS_URL
        flag 6 (0x7L): serverConfigVM
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}