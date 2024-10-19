//ページ遷移
function pageTransition(id){
	$("form").attr("action","/" + id);
    $("form").submit();
}

//engineer関連のページへ遷移
function engineerPageTransition(id){
	if(location.href.indexOf("engineer") > 0){
		$("form").attr("action", id);
	}else{
		$("form").attr("action","engineer/" + id);
	}
    $("form").submit();
}

//user関連のページへ遷移
function userPageTransition(id){
	if(location.href.indexOf("user") > 0){
		$("form").attr("action", id);
	}else{
		$("form").attr("action","user/" + id);
	}
    $("form").submit();
}
