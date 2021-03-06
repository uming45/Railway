package cn.dazhou.railway.im.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by hooyee on 2017/5/18.
 */

@Table(database = RailwayDatabase.class)
public class UserModel extends BaseModel{
    @PrimaryKey
    private String username;   //用户jid
    @Column
    private String password;   //用户密码
    @Column
    private boolean firstLogin = false; // 记录用户是否第一次在当前机器登录, 默认为非第一次
    List<FriendModel> friends;

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "friends")
    public List<FriendModel> getMyFriends() {
        if (friends == null || friends.isEmpty()) {
            friends = SQLite.select()
                    .from(FriendModel.class)
                    .where(FriendModel_Table.possessor.eq(username))
                    .queryList();
        }
        return friends;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
}
