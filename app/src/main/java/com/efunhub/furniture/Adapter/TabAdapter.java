package com.efunhub.furniture.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.efunhub.furniture.Fragment.BedsFragment;
import com.efunhub.furniture.Fragment.BookshelvesFragment;
import com.efunhub.furniture.Fragment.CoffeeTablesFragment;
import com.efunhub.furniture.Fragment.DiningFragment;
import com.efunhub.furniture.Fragment.HomeFragment;
import com.efunhub.furniture.Fragment.ShoeRacksFragment;
import com.efunhub.furniture.Fragment.SofaFragment;
import com.efunhub.furniture.Fragment.TvUnitsFragment;


public class TabAdapter extends FragmentPagerAdapter
{

    public TabAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new SofaFragment();
            case 2:
                return new BedsFragment();
            case 3:
                return new DiningFragment();
            case 4:
                return new TvUnitsFragment();
            case 5:
                return new CoffeeTablesFragment();
            case 6:
                return new ShoeRacksFragment();
            case 7:
                return new BookshelvesFragment();

        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 8;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
//
//Your tab titles
//
            case 0:return "Home";
            case 1:return "Sofas";
            case 2:return "Beds";
            case 3:return "Dining";
            case 4:return "TV Units";
            case 5:return "Coffee Tables";
            case 6:return "Shoe Racks";
            case 7:return "Bookshelves";
            case 8:return "Storage";
            default:return null;
        }
    }
}
