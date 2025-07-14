
Данный проект я решил написать с помощью многомодульной архитектуры. 
Это мой первый опыт в таком формате.

Основа приложения в модуле :app
модуль :core содержит слои domain, data
модуль feature раскрывает два экрана - начальный и детальной информации

paging source: https://developer.android.com/reference/kotlin/androidx/paging/PagingSource
remote mediator: https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator

все провайдеры hilt собраны в модуле :core:di

:core:domain описывает поведние приложения, его бизнес логику