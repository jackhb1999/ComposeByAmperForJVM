import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import screen.HomeScreen
import screen.LoginScreen
import tab.HomeTab
import tab.ProfileTab
import tab.SettingTab
import view.CountView
import view.HomeView
import view.LoginView
import view.SignUpView


// 1. 创建自定义 ViewModelStoreOwner
class DesktopViewModelStoreOwner : ViewModelStoreOwner {
    override val viewModelStore = ViewModelStore()
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        val owner = remember { DesktopViewModelStoreOwner() }
        // 将其提供给 Compose 树
        CompositionLocalProvider(LocalViewModelStoreOwner provides owner) {
            MaterialTheme {
//                CountView()
//                SignUpView()
//                LoginView()
                Navigator(LoginScreen()) { navigator ->
                    SlideTransition(navigator)
                }
//                Navigator(HomeScreen()) { navigator ->
//                    SlideTransition(navigator)
//                }


            }
        }
    }
}


