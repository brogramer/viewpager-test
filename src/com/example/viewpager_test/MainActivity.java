package com.example.viewpager_test;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	  /** 页面list **/
    List<Fragment> fragmentList = new ArrayList<Fragment>();
    /** 页面标题 list **/
    List<String>   titleList    = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);

        ViewPager vp = (ViewPager)findViewById(R.id.viewPager);
        fragmentList.add(new MainViewPagerFragment("页面1"));
        fragmentList.add(new MainViewPagerFragment("页面2"));
        fragmentList.add(new MainViewPagerFragment("页面3"));
        titleList.add("标题 1 ");
        titleList.add("标题 2 ");
        titleList.add("标题 3 ");
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
    }
}

class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String>   titleList;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList){
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    /**
     * 得到每个页面
     */
    @Override
    public Fragment getItem(int arg0) {
        return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(arg0);
    }

    /**
     * 每个页面的title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return (titleList.size() > position) ? titleList.get(position) : "";
    }

    /**
     * 页面的总个数
     */
    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}


class MainViewPagerFragment extends Fragment {
	
	private String   text;
	private TextView tv = null;
	
	public MainViewPagerFragment(String text){
		super();
		this.text = text;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment, container, false);
		tv = (TextView)v.findViewById(R.id.viewPagerText);
		tv.setText(text);
		return v;
	}
}
