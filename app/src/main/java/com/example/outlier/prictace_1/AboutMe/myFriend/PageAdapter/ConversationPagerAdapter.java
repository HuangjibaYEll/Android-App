package com.example.outlier.prictace_1.AboutMe.myFriend.PageAdapter;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.outlier.prictace_1.AboutMe.chat.App;
import com.example.outlier.prictace_1.BaseApplication;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;


/**
 * Created by mummyding on 15-8-29.
 */
public class ConversationPagerAdapter extends BasePagerAdapter {
    public ConversationPagerAdapter(FragmentManager fm, CharSequence[] mTitles, int mNumbOfTabsumb) {
        super(fm, mTitles, mNumbOfTabsumb);
    }
    @Override
    public Fragment getItem(int position) {
        /*
         *position 0 表示联系人 1表示联系群
         */
        if(position == 0)
        {
            ConversationListFragment listFragment = new ConversationListFragment();
            Uri uri = Uri.parse("rong://" + BaseApplication.context().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊不采用聚合显示
                    .build();
            listFragment.setUri(uri);
            return listFragment;
        }
        else
        {
           ConversationListFragment listFragment = new ConversationListFragment();
            Uri uri = Uri.parse("rong://" + BaseApplication.context().getApplicationInfo().packageName).buildUpon()
                        .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false") //设置群组会话不采用聚合显示
                    .build();
            listFragment.setUri(uri);
            return listFragment;
        }

    }
}
