package ua.blackwind.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ua.blackwind.data.db.model.CatImageDbModel
import ua.blackwind.data.db.model.FavoriteCatFactDBModel
import ua.blackwind.data.db.model.RandomCatFactDbModel

@Dao
interface CatFactsDao {

    @Insert
    suspend fun insertRandomCatFact(catFact: RandomCatFactDbModel)

    @Insert
    suspend fun insertFavoriteCatFact(catFactDBModel: FavoriteCatFactDBModel)

    @Insert
    suspend fun insertCatImage(catImage: CatImageDbModel)

    @Query("DELETE FROM facts_random WHERE id == :id")
    suspend fun deleteRandomCatFactById(id: Int)

    @Query("DELETE FROM facts_favorite WHERE id == :id")
    suspend fun deleteFavoriteCatFactById(id: Int)

    @Query("DELETE FROM cat_image WHERE id == :id")
    suspend fun deleteCatImageById(id: Int)

    @Query("SELECT * FROM facts_random ORDER BY id DESC")
    fun getAllRandomCatFacts(): List<RandomCatFactDbModel>

    @Query("SELECT * FROM facts_favorite ORDER BY id DESC")
    fun getAllFavoriteCatFacts(): List<FavoriteCatFactDBModel>

    @Query("SELECT * FROM cat_image ORDER BY id DESC")
    fun getAllCatImages(): List<CatImageDbModel>
}