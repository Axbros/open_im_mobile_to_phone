package io.openim.android.demo.ui.user;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import java.util.List;
import io.openim.android.demo.databinding.ActivityPersonalInfoBinding;
import io.openim.android.demo.ui.main.EditTextActivity;
import io.openim.android.demo.vm.PersonalVM;
import io.openim.android.ouicore.base.BaseActivity;
import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.utils.Constants;
import io.openim.android.ouicore.utils.RegexValid;
import io.openim.android.ouicore.utils.SharedPreferencesUtil;
import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.models.GroupInfo;
public class PersonalInfoActivity extends BaseActivity<PersonalVM, ActivityPersonalInfoBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bindVM(PersonalVM.class);
        super.onCreate(savedInstanceState);
        bindViewDataBinding(ActivityPersonalInfoBinding.inflate(getLayoutInflater()));
        vm.getSelfUserInfo();

        initView();
        click();
    }

    private void click() {

//
//        view.nickNameLy.setOnClickListener(v ->
//            nicknameLauncher.launch(new Intent(this, EditTextActivity.class)
//                .putExtra(EditTextActivity.INIT_TXT, vm.userInfo.val().getNickname())
//                .putExtra(EditTextActivity.MAX_LENGTH, 16)
//                .putExtra(EditTextActivity.TITLE,
//                    getString(io.openim.android.ouicore.R.string.NickName))));

        view.parentUidTv.setOnClickListener(v->{
            OpenIMClient.getInstance().groupManager.getJoinedGroupList(new OnBase<List<GroupInfo>>() {
                @Override
                public void onError(int code, String error) {
                    Toast.makeText(BaseApp.inst(),"获取ParentUID失败:"+error,Toast.LENGTH_LONG);
                    view.parentUidTv.setText("获取失败："+error);
                }
                @Override
                public void onSuccess(List<GroupInfo> data) {
                    if(!data.isEmpty()){
                        for(GroupInfo group:data){
                            String ParentUID=group.getOwnerUserID();
                            SharedPreferencesUtil.get(BaseApp.inst()).setCache(Constants.K_PARENT_UID, ParentUID);
                            Toast.makeText(BaseApp.inst(),"成功获取Parent UID:"+ParentUID,Toast.LENGTH_LONG);
                            view.parentUidTv.setText(ParentUID);
                            break;
                        }
                    }else{
                        Toast.makeText(BaseApp.inst(),"获取ParentUID失败，群组信息为空",Toast.LENGTH_LONG);
                        SharedPreferencesUtil.get(BaseApp.inst()).setCache("PARENT_UID", "没有绑定对应关系，请联系管理员");
                        view.parentUidTv.setText("刷新成功,群组为空");
                    }
                }
            });
        });

    }

    private final ActivityResultLauncher<Intent> nicknameLauncher =
        registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() != Activity.RESULT_OK) return;
            String resultStr = result.getData().getStringExtra(Constants.K_RESULT);
            vm.setNickname(resultStr);
        });

    private void initView() {
        vm.userInfo.observe(this, v -> {
            if (null == v) return;
//            view.avatar.load(v.getFaceURL(), v.getNickname());
            view.nickName.setText(v.getNickname());
//            view.gender.setText(v.getGender() == 1 ? io.openim.android.ouicore.R.string.male :
//                io.openim.android.ouicore.R.string.girl);
//            if (v.getBirth() > 0) {
//                view.birthday.setText(TimeUtil.getTime(v.getBirth(),
//                    TimeUtil.yearMonthDayFormat));
//            }
//            view.phoneNumTv.setText(v.getPhoneNumber());
            view.parentUidTv.setText(SharedPreferencesUtil.get(BaseApp.inst()).getString(Constants.K_PARENT_UID));
//            view.emailTV.setText(v.getEmail());
        });
    }
}
