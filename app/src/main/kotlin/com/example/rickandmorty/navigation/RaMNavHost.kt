package com.example.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rickandmorty.feature.details.Details
import com.example.rickandmorty.feature.home.Home
import com.example.rickandmorty.feature.home.navigation.HomeRoute

@Composable
fun RaMNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        composable<HomeRoute> {
            Home(
                onCharacterClick = { id ->
//                    navController.navigate(CharacterDetailRoute(id.toString()))
//                    navController.navigateToCharacterDetail(id)
                    navController.navigate("character_detail/$id")
                }
            )
        }

//        composable<CharacterDetailRoute> { route ->
//            Details(characterId = route.id.toInt())
//        }
        composable(
            route = "character_detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            Details(characterId = id)
        }

    }
}

