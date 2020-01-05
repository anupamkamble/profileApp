package com.profileapp.data.remote.network

//all api List
//https://api.projects.bootcamp.mindorks.com/batch/green/


object EndPoints {
    const val DUMMY_CALL = "dummy/list"
    const val SIGNUP = "signup/mindorks'"
    const val LOGIN = "login/mindorks"


    const val LOGOUT = "logout"
    const val GET_MY_DETAILS ="me"
    const val UPDATE_MY_DETAILS = "me"
    const val UPLOAD_IMAGE = ""
    const val DOWNLOAD_IMAGE = ""
    const val POST_CREATE  = "instagram/post"
    const val GET_POST_DETAILS = "instagram/post/id/{postId}"
    const val DELETE_POST = "instagram/post/id/{postId}"
    const val GET_MY_POSTS = "instagram/post/my"
    const val GET_ALL_POSTS_LIST = "instagram/post/list?firstPostId={id}&lastPostId={id}"
    const val LIKE_POST = "instagram/post/like"
    const val UNLIKE_POST = "instagram/post/unlike"
}