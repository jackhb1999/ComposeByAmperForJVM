import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.icons.FeatherIcons
import compose.icons.feathericons.Clock
import compose.icons.feathericons.Eye
import compose.icons.feathericons.EyeOff
import compose.icons.feathericons.Key
import compose.icons.feathericons.Lock

import compose.icons.feathericons.User


@Composable
@Preview
fun test_input() {
    Column {

        var username by remember { mutableStateOf("") }
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = {
                Icon(
//                    imageVector = Icons.Default.Person,
                    imageVector = FeatherIcons.User,
                    contentDescription = "用户名图标",
                    tint = Color.Blue,
                )
            },
            label = { Text("用户名") },
            placeholder = { Text("请输入用户名") }, singleLine = true
        )

        Spacer(modifier = Modifier.padding(6.dp))
        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = FeatherIcons.Lock,
                    contentDescription = "密码图标",
                    tint = Color.Blue,
                )
            },
            label = { Text("密码") },
            placeholder = { Text("请输入密码") },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        imageVector = if (passwordVisibility) FeatherIcons.Eye else FeatherIcons.EyeOff,
                        contentDescription = "密码图标",
                        tint = Color.Blue
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true
        )
    }
}

@Composable
@Preview
fun Add_count() {
    Column {
//        var count = remember { mutableStateOf(0) }
        // 使用委托
        var count by remember { mutableStateOf(0) }
        BasicText("${count}")
        Button(onClick = { count++ }) {
            BasicText("增加")
        }
    }
}


@Composable
@Preview
fun Add_count_less(count: Int, onChange: () -> Unit) {
    Column {
        BasicText("${count}")
        Button(onClick = { onChange() }) {
            BasicText("改变")
        }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),// 充满整个屏幕
            verticalArrangement = Arrangement.Center, // 水平居中
            horizontalAlignment = Alignment.CenterHorizontally, // 垂直居中
        ) {
            Text("我是世界", fontSize = 16.sp)
            BasicText("Hello, World!")
            Button(
                onClick = { println("Hello, World!") },
                modifier = Modifier.padding(32.dp)
            ) {
                BasicText("按钮")
            }
            Add_count()
            // 无状态
            var count by remember { mutableStateOf(0) }
            Add_count_less(count) {
                count += 2
            }

            test_input()
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}