package com.forbitbd.task.ui.main.buttonFragment;




import com.forbitbd.myplayer.models.Category;

import java.util.List;

public interface ButtonContract {

    interface Presenter{
        void getAllCategories();
    }

    interface View{
        void renderCategory(List<Category> categoryList);
        void catClick(Category category);
    }
}
