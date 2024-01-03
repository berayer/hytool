/**
 * 开屏加载动画
 * @link https://tobiasahlin.com/spinkit/
 */
import '@/styles/loading.css'

export function loading() {
  const spinner = createDiv('app-spinner')

  const rect1 = createDiv('rect1')
  const rect2 = createDiv('rect2')
  const rect3 = createDiv('rect3')
  const rect4 = createDiv('rect4')

  spinner.appendChild(rect1)
  spinner.appendChild(rect2)
  spinner.appendChild(rect3)
  spinner.appendChild(rect4)

  document.body.appendChild(spinner)
}

function createDiv(className: string) {
  const div = document.createElement('div')
  div.className = className
  return div
}

export function removeLoading(time: number = 1000) {
  const spinner = document.querySelector('.app-spinner')
  if (spinner) {
    setTimeout(() => {
      spinner.remove()
    }, time)
  }
}
