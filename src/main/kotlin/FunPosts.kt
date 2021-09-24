class FunPosts {

    fun friendsOnly(friendsOnly: Boolean): String {
        when(friendsOnly) {
            true -> return " Запись только для друзей! "
            else -> return " Запись доступна для всех! "
        }
    }

    fun canPin(canPin: Boolean): String {
        if (canPin == true) return " Запись закреплена. "
        else return " У вас нет прав на закрепление записи. "
    }

    fun canDelete(canDelete: Boolean): String {
        if (canDelete == true) return " Запись удалена. "
        else return " У вас нет прав на удаление записи. "
    }


    fun canEdit(canEdit: Boolean): String {
        if (canEdit == true) return " Запись отредактирована. "
        else return " У вас нет прав на редактирование записи. "
    }

    fun isPinned(isPinned: Boolean): String {
        if (isPinned == true) return " Запись закреплена. "
        else return " Ошибка! Запись не закреплена! "
    }

    fun markedAsAds(markedAsAds: Boolean): String {
        if (markedAsAds == true) return " Содержит рекламу! "
        else return " Не содержит рекламу! "
    }

    fun isFavorite(isFavorite: Boolean): String {
        if (isFavorite == true) return " Запись добавлена в закладки! "
        else return " Запись не добавлена в закладки! "
    }



}