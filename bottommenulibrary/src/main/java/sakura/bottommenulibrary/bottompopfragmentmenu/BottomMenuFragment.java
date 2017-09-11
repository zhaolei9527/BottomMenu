package sakura.bottommenulibrary.bottompopfragmentmenu;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sakura.bottommenulibrary.R;


public class BottomMenuFragment extends DialogFragment {

    private final String TAG = "BottomMenuFragment";
    private Activity context;
    private OnItemClickListener mOnItemClickListener;

    public BottomMenuFragment(Activity context) {
        this.context = context;
    }

    private List<MenuItem> menuItemList = new ArrayList<MenuItem>();

    public List<MenuItem> getMenuItems() {
        return menuItemList;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItemList.addAll(menuItems);
    }

    public BottomMenuFragment setMenuItems(MenuItem menuItems) {
        menuItemList.add(menuItems);
        return this;
    }

    public void show() {
        this.show(context.getFragmentManager(), "BottomMenuFragment");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//设置背景透明
        getDialog().getWindow().setWindowAnimations(R.style.menu_animation);//添加一组进出动画
        View view = inflater.inflate(R.layout.fragment_bottom_menu, container, false);
        //view.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.menu_appear));//添加一个加载动画，这样的问题是没办法添加消失动画，有待进一步研究
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: tv_cancel");
                BottomMenuFragment.this.dismiss();
            }
        });
        ListView lv_menu = (ListView) view.findViewById(R.id.lv_menu);
        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(getActivity().getBaseContext(), this.menuItemList);
        lv_menu.setAdapter(menuItemAdapter);
        lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onClick: ");
                if (mOnItemClickListener != null) {
                    TextView menu_item = (TextView) view.findViewById(R.id.menu_item);
                    mOnItemClickListener.onItemClick(menu_item, position);
                    dismiss();
                }

            }
        });
        return view;
    }

    public interface OnItemClickListener {
        void onItemClick(TextView menu_item, int position);
    }

    public BottomMenuFragment setOnItemClickListener(@Nullable OnItemClickListener listener) {
        mOnItemClickListener = listener;
        return this;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");

        //设置弹出框宽屏显示，适应屏幕宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        getDialog().getWindow().setLayout(dm.widthPixels, getDialog().getWindow().getAttributes().height);

        //移动弹出菜单到底部
        WindowManager.LayoutParams wlp = getDialog().getWindow().getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        // wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes(wlp);
    }

    @Override
    public void onStop() {
        this.getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.menu_disappear));
        super.onStop();
    }
}
