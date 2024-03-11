package com.axiagroups.roomworksample.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.axiagroups.roomworksample.model.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("SELECT word FROM word_table WHERE word LIKE '%' || :str || '%' ORDER BY word ASC")
    LiveData<List<Word>> search(String str);
}
