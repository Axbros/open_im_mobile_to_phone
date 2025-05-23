// Generated by data binding compiler. Do not edit!
package io.openim.android.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.openim.android.demo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityResetPasswordBinding extends ViewDataBinding {
  @NonNull
  public final EditText edt2;

  @NonNull
  public final EditText edt3;

  @NonNull
  public final CheckBox eyes;

  @NonNull
  public final CheckBox eyes2;

  @NonNull
  public final Button submit;

  protected ActivityResetPasswordBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText edt2, EditText edt3, CheckBox eyes, CheckBox eyes2, Button submit) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edt2 = edt2;
    this.edt3 = edt3;
    this.eyes = eyes;
    this.eyes2 = eyes2;
    this.submit = submit;
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_reset_password, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityResetPasswordBinding>inflateInternal(inflater, R.layout.activity_reset_password, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_reset_password, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityResetPasswordBinding>inflateInternal(inflater, R.layout.activity_reset_password, null, false, component);
  }

  public static ActivityResetPasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityResetPasswordBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityResetPasswordBinding)bind(component, view, R.layout.activity_reset_password);
  }
}
